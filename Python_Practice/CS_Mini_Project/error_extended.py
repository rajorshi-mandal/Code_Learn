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

def damping_characteristics(system):
    poles = np.roots(system.den[0][0])
    damping_ratio = np.abs(np.real(poles)) / np.abs(poles)

    if np.all(damping_ratio == 1):
        return "Critically Damped"
    elif np.all(damping_ratio > 1):
        return "Overdamped"
    elif np.all(damping_ratio < 1):
        return "Underdamped"
    elif np.all(damping_ratio == 0):
        return "Undamped"
    else:
        return "Mixed Damping"

def time_domain_specs(t, y):
    # Rise Time
    Tr = t[np.where(y >= 0.9 * y[-1])[0][0]] - t[np.where(y >= 0.1 * y[-1])[0][0]]
    
    # Peak Time
    Tp = t[np.argmax(y)]
    
    # Settling Time
    steady_state_value = y[-1]
    within_bounds = np.where(np.abs(y - steady_state_value) <= 0.02 * steady_state_value)[0]
    Ts = t[within_bounds[-1]] if len(within_bounds) > 0 else t[-1]
    
    # Peak Overshoot
    Mp = (np.max(y) - steady_state_value) / steady_state_value * 100

    return Tr, Tp, Ts, Mp

def calculate_and_plot():
    try:
        numerator = list(map(float, numerator_entry.get().split(',')))
        denominator = list(map(float, denominator_entry.get().split(',')))
        system = ctrl.TransferFunction(numerator, denominator)

        T = np.linspace(0, 10, 1000)  # 10 seconds, 1000 points

        # Calculate performance indices
        iae, ise, itae, itse = performance_indices(system, T)
        
        # Calculate damping characteristics
        damping = damping_characteristics(system)

        # Calculate time-domain specifications
        t, y = ctrl.step_response(system, T)
        Tr, Tp, Ts, Mp = time_domain_specs(t, y)

        results_text.set(
            f"IAE: {iae}\nISE: {ise}\nITAE: {itae}\nITSE: {itse}\n"
            f"Damping: {damping}\nRise Time: {Tr}\nPeak Time: {Tp}\n"
            f"Settling Time: {Ts}\nPeak Overshoot: {Mp}%"
        )

        # Plot the step response
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
