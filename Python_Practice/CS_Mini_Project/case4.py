import numpy as np
import sympy as sp
import matplotlib.pyplot as plt

# Define symbols
s = sp.symbols('s')
t = sp.symbols('t', real=True, positive=True)
wn, z = sp.symbols('wn z', real=True, positive=True)

# Define transfer function
C_over_R = 25 / (s**2 + 6 * s + 25)

system = ""

# Find natural frequency and damping ratio
sol = sp.solve(C_over_R - wn**2 / (s**2 + 2 * z * wn * s + wn**2), (wn, z))
print(sol)

if sol:
    wn_val = sol[wn]
    z_val = sol[z]

    # Calculate rise time
    theta = sp.atan(sp.sqrt(1 - z_val**2) / z_val)
    wd = wn_val * sp.sqrt(1 - z_val**2)
    Tr = (sp.pi - theta) / wd if z_val < 1 else sp.oo

    # Calculate peak time
    Td = sp.pi / wd if z_val < 1 else sp.oo

    # Calculate peak overshoot
    Mp = sp.exp(-sp.pi * z_val / sp.sqrt(1 - z_val**2)) * 100 if z_val < 1 else sp.nan

    # Calculate maximum peak overshoot
    Max_Mp = Mp.evalf() if z_val < 1 else sp.nan

    # Calculate settling time
    Ts = 4 / (z_val * wn_val)

    # Calculate output response based on damping type
    if z_val < 1:  # Underdamped
        c_t = 1 - (sp.exp(-z_val * wn_val * t) / sp.sqrt(1 - z_val**2)) * sp.sin(wd * t + theta)
        system = "underdamped system"
    elif z_val == 1:  # Critically damped
        c_t = 1 - (sp.exp(-wn_val * t)) * (1 + wn_val * t)
        system = "critically damped system"
    else:  # Overdamped
        s1 = z_val * wn_val - wn_val * sp.sqrt(z_val**2 - 1)
        s2 = z_val * wn_val + wn_val * sp.sqrt(z_val**2 - 1)
        c_t = 1 - (wn_val / (2 * sp.sqrt(z_val**2 - 1))) * ((sp.exp(-s1 * t)) / s1 - (sp.exp(-s2 * t)) / s2)
        system = "overdamped system"

    # Display results
    print("Natural Frequency (ωn): {} rad/s".format(wn_val))
    print("Damping Ratio (ζ): {}".format(z_val))
    print("Rise Time (Tr): {} s".format(Tr if Tr.is_infinite else "∞"))
    print("Peak Time (Td): {} s".format(Td if Td.is_infinite else "∞"))
    print("Peak Overshoot (%Mp):", Mp.evalf(), "%" if not Mp.is_infinite else "")
    print("Maximum Peak Overshoot:", Max_Mp, "%" if not Max_Mp.is_infinite else "")
    print("Settling Time (Ts): {} s".format(Ts.evalf()))

    # Calculate points for plot
    t_values = np.linspace(0, 10, 500)
    c_values = [c_t.subs(t, val).evalf() for val in t_values]

    # Plot
    plt.figure(figsize=(10, 6))
    plt.plot(t_values, c_values, label='Output Response')
    if not Tr.is_infinite:
        plt.scatter(float(Tr), c_t.subs(t, Tr).evalf(), color='red', label=f'Rise Time: ({float(Tr):.2f}, {c_t.subs(t, Tr).evalf():.2f})')
    if not Td.is_infinite:
        plt.scatter(float(Td), c_t.subs(t, Td).evalf(), color='blue', label=f'Peak Time: ({float(Td):.2f}, {c_t.subs(t, Td).evalf():.2f})')
    if not Mp.is_infinite:
        plt.scatter(4/z_val/wn_val, c_t.subs(t, 4/z_val/wn_val).evalf(), color='green', label=f'Settling Time: ({4/z_val/wn_val:.2f}, {c_t.subs(t, 4/z_val/wn_val).evalf():.2f})')
    plt.xlabel('Time (t)')
    plt.ylabel('Output Response (c(t)) ')
    plt.title('Output Response : {}'.format(system))
    plt.legend()
    plt.grid(True)
    plt.show()
else:
    print("No solution found.")
