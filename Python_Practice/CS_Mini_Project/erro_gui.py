import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import simps
import control as ctrl
import tkinter as tk
from tkinter import messagebox

def performance_indices(system, T):
    t, y = ctrl.step_response(system, T)
    e = 1 - y  # Assuming unit step input, so desired output is 1

    iae = simps(np.abs(e), t)
    ise = simps(e**2, t)
    itae = simps(t * np.abs(e), t)
    itse = simps(t * e**2, t)

    return iae, ise, itae, itse

def calculate_and_plot():
    try:
        numerator = list(map(float, numerator_entry.get().split(',')))
        denominator = list(map(float, denominator_entry.get().split(',')))
        system = ctrl.TransferFunction(numerator, denominator)

        T = np.linspace(0, 10, 1000)  # 10 seconds, 1000 points

        iae, ise, itae, itse = performance_indices(system, T)

        results_text.set(f"IAE: {iae}\nISE: {ise}\nITAE: {itae}\nITSE: {itse}")

        # Plot the step response
        t, y = ctrl.step_response(system, T)
        plt.figure()
        plt.plot(t, y)
        plt.title('Step Response')
        plt.xlabel('Time (s)')
        plt.ylabel('Output')
        plt.grid()
        plt.show()

    except Exception as e:
        messagebox.showerror("Error", str(e))

# Create the main window
root = tk.Tk()
root.title("Control System Performance Indices")

# Create and place the widgets
tk.Label(root, text="Numerator (comma-separated):").grid(row=0, column=0, padx=10, pady=10)
numerator_entry = tk.Entry(root, width=50)
numerator_entry.grid(row=0, column=1, padx=10, pady=10)

tk.Label(root, text="Denominator (comma-separated):").grid(row=1, column=0, padx=10, pady=10)
denominator_entry = tk.Entry(root, width=50)
denominator_entry.grid(row=1, column=1, padx=10, pady=10)

calculate_button = tk.Button(root, text="Calculate and Plot", command=calculate_and_plot)
calculate_button.grid(row=2, columnspan=2, pady=20)

results_text = tk.StringVar()
results_label = tk.Label(root, textvariable=results_text, justify=tk.LEFT)
results_label.grid(row=3, columnspan=2, padx=10, pady=10)

# Run the application
root.mainloop()
