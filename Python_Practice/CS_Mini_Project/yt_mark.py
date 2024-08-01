import numpy as np
import sympy as sp
import matplotlib.pyplot as plt

# Define symbols
s = sp.symbols('s')
t = sp.symbols('t', real=True, positive=True)
wn, z = sp.symbols('wn z', real=True, positive=True)

# Define transfer function
C_over_R = 25 / (s**2 + 6 * s + 25)

# Find natural frequency and damping ratio
sol = sp.solve(C_over_R - wn**2 / (s**2 + 2 * z * wn * s + wn**2), (wn, z))
print(sol)

if sol:
    wn_val = sol[wn]
    z_val = sol[z]

    # Calculate rise time
    theta = sp.atan(sp.sqrt(1 - z_val**2) / z_val)
    wd = wn_val * sp.sqrt(1 - z_val**2)
    print("wd : {}".format(wd))
    Tr = (sp.pi - theta) / wd

    # Calculate peak time
    Td = sp.pi / wd

    # Calculate peak overshoot
    Mp = sp.exp(-sp.pi * z_val / sp.sqrt(1 - z_val**2)) * 100

    # Calculate maximum peak overshoot
    Max_Mp = Mp.evalf()

    # Calculate settling time
    Ts = 4 / (z_val * wn_val)

    # Calculate output response
    c_t = 1 - (sp.exp(-z_val * wn_val * t) / sp.sqrt(1 - z_val**2)) * sp.sin(wd * t + theta)

    # Display results
    print("ωn = {} rad/s".format(wn_val))
    print("θ = {} rad".format(theta.evalf()));
    print("Rise Time (Tr): {} s".format(Tr.evalf()))
    print("Peak Time (Td): {} s".format(Td.evalf()))
    print("Peak Overshoot (%Mp):", Mp.evalf(), "%")
    print("Maximum Peak Overshoot:", Max_Mp, "%")
    print("Settling Time (Ts): {} s".format(Ts.evalf()))

    # Calculate points for plot
    t_values = np.linspace(0, 10, 500)
    c_values = [c_t.subs(t, val).evalf() for val in t_values]

    # Plot
    plt.figure(figsize=(10, 6))
    plt.plot(t_values, c_values, label='Output Response')
    plt.scatter(Tr, c_t.subs(t, Tr).evalf(), color='red', label=f'Rise Time: ({Tr.evalf():.2f}, {c_t.subs(t, Tr).evalf():.2f})')
    plt.scatter(Td, c_t.subs(t, Td).evalf(), color='blue', label=f'Peak Time: ({Td.evalf():.2f}, {c_t.subs(t, Td).evalf():.2f})')
    plt.scatter(4/z_val/wn_val, c_t.subs(t, 4/z_val/wn_val).evalf(), color='green', label=f'Settling Time: ({4/z_val/wn_val:.2f}, {c_t.subs(t, 4/z_val/wn_val).evalf():.2f})')
    # plt.scatter(0, Mp_point, color='orange', label=f'Peak Overshoot: ({0:.2f}, {Mp_point:.2f})')
    plt.xlabel('Time (t)')
    plt.ylabel('Output Response (c(t))')
    plt.title('Output Response')
    plt.legend()
    plt.grid(True)
    plt.show()
else:
    print("No solution found.")
