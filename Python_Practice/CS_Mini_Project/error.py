import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import simps
import control as ctrl

def performance_indices(system, T):
    t, y = ctrl.step_response(system, T)
    e = 1 - y  # Assuming unit step input, so desired output is 1

    iae = simps(np.abs(e), t)
    ise = simps(e**2, t)
    itae = simps(t * np.abs(e), t)
    itse = simps(t * e**2, t)

    return iae, ise, itae, itse

# Define the transfer function
numerator = [25]  # Replace with your numerator coefficients
denominator = [1, 12, 25]  # Replace with your denominator coefficients
system = ctrl.TransferFunction(numerator, denominator)

# Define the time range for the simulation
T = np.linspace(0, 10, 1000)  # 10 seconds, 1000 points

# Calculate performance indices
iae, ise, itae, itse = performance_indices(system, T)

print(f"Integral of Absolute Error (IAE): {iae}")
print(f"Integral of Squared Error (ISE): {ise}")
print(f"Integral of Time-weighted Absolute Error (ITAE): {itae}")
print(f"Integral of Time-weighted Squared Error (ITSE): {itse}")

# Optionally, plot the response
t, y = ctrl.step_response(system, T)
plt.plot(t, y)
plt.title('Step Response')
plt.xlabel('Time (s)')
plt.ylabel('Output')
plt.grid()
plt.show()
