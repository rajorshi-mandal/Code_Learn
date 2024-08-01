import numpy as np
import sympy as sp
import matplotlib.pyplot as plt
import tkinter as tk

def calculate_response():
    # Get numerator and denominator coefficients
    num_coeffs = [float(x) for x in num_entry.get().split(',')]
    den_coeffs = [float(x) for x in den_entry.get().split(',')]
    
    # Define symbols
    s = sp.symbols('s')
    t = sp.symbols('t', real=True, positive=True)
    wn, z = sp.symbols('wn z', real=True, positive=True)

    # Define transfer function
    C_over_R = sp.Poly(num_coeffs, s) / sp.Poly(den_coeffs, s)

    # Find natural frequency and damping ratio
    sol = sp.solve(C_over_R - wn**2 / (s**2 + 2 * z * wn * s + wn**2), (wn, z))
    print(type(sol))

    if sol:
        wn_val = sol[wn]
        z_val = sol[z]
        print(type(wn_val))
        print(type(z_val))
        print("wn : {}".format(wn_val))
        print("z : {}".format(z_val))

        # Calculate rise time
        theta = sp.atan(sp.sqrt(1 - z_val**2) / z_val)
        wd = wn_val * sp.sqrt(1 - z_val**2)
        
        Tr = (sp.pi - theta) / wd 
        Td = sp.pi / wd 
        
        temp_r = Tr
        temp_d = Td
        
        if z_val < 1 :
            temp_r = Tr.evalf()
            temp_d = Td.evalf()
            print("Tr : {}".format(Tr.evalf()))
            print("Tf : {}".format(Td.evalf()))
        elif z_val >= 1:
            temp_r = Tr
            temp_d = Td
            print("Tr : {}".format(Tr))
            print("Tf : {}".format(Td))
        
        if z_val >= 1:
            Tr = (sp.pi - theta) / wd if z_val < 1 else sp.oo
            Td = sp.pi / wd if z_val < 1 else sp.oo

        # Calculate peak time

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
        output_text.config(state=tk.NORMAL)
        output_text.delete('1.0', tk.END)
        output_text.insert(tk.END, "Natural Frequency (ωn): {} rad/s\n".format(wn_val))
        output_text.insert(tk.END, "Damping Ratio (ζ): {}\n".format(z_val))
        output_text.insert(tk.END, "Rise Time (Tr): {} s\n".format(temp_r))
        output_text.insert(tk.END, "Peak Time (Td): {} s\n".format(temp_d))
        output_text.insert(tk.END, "Peak Overshoot (%Mp): {} %\n".format(Mp.evalf() if not Mp.is_infinite else ""))
        output_text.insert(tk.END, "Maximum Peak Overshoot: {} %\n".format(Max_Mp if not Max_Mp.is_infinite else ""))
        output_text.insert(tk.END, "Settling Time (Ts): {} s\n".format(Ts.evalf()))
        output_text.config(state=tk.DISABLED)

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
        output_text.config(state=tk.NORMAL)
        output_text.delete('1.0', tk.END)
        output_text.insert(tk.END, "No solution found.")
        output_text.config(state=tk.DISABLED)

# Create GUI
root = tk.Tk()
root.title("Second Order System Response Calculator")

num_label = tk.Label(root, text="Numerator Coefficients (comma-separated):")
num_label.pack()
num_entry = tk.Entry(root)
num_entry.pack()

den_label = tk.Label(root, text="Denominator Coefficients (comma-separated):")
den_label.pack()
den_entry = tk.Entry(root)
den_entry.pack()

calculate_button = tk.Button(root, text="Calculate Response", command=calculate_response)
calculate_button.pack()

output_text = tk.Text(root, height=10, width=80)
output_text.pack()
output_text.config(state=tk.DISABLED)

root.mainloop()
