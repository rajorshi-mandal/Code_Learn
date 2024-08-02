import numpy as np
import sympy as sp

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
    print("Rise Time (Tr):", Tr.evalf())
    print("Peak Time (Td):", Td.evalf())
    print("Peak Overshoot (%Mp):", Mp.evalf(), "%")
    print("Maximum Peak Overshoot:", Max_Mp, "%")
    print("Settling Time (Ts):", Ts.evalf())

    # Output response plot
    sp.plot(c_t, (t, 0, 10), xlabel='Time (t)', ylabel='Output Response (c(t))', title='Output Response')
else:
    print("No solution found.")
