import control as ctrl
import numpy as np
import matplotlib.pyplot as plt

def compute_system_characteristics(num, den):
    # Define the transfer function
    system = ctrl.TransferFunction(num, den)
    
    # Get the step response
    time, response = ctrl.step_response(system)
    
    # Peak time
    peak_time = time[np.argmax(response)]
    
    # Peak value
    peak_value = np.max(response)
    
    # Steady-state value (assumed to be the last value of the response)
    steady_state_value = response[-1]
    
    # Percentage overshoot
    percentage_overshoot = (peak_value - steady_state_value) / steady_state_value * 100
    
    # Rise time (time to go from 10% to 90% of the steady-state value)
    rise_time_indices = np.where((response >= 0.1 * steady_state_value) & (response <= 0.9 * steady_state_value))
    if rise_time_indices[0].size > 0:
        rise_time = time[rise_time_indices][-1] - time[rise_time_indices][0]
    else:
        rise_time = None
    
    # Settling time (time to stay within 2% of the steady-state value)
    settling_time_indices = np.where(np.abs(response - steady_state_value) <= 0.02 * steady_state_value)[0]
    if settling_time_indices.size > 0:
        settling_time = time[settling_time_indices[-1]]
    else:
        settling_time = None

    return peak_time, rise_time, settling_time, percentage_overshoot

# Example transfer function (e.g., G(s) = 1 / (s^2 + 2s + 2))
numerator = [1]
denominator = [1, 2, 2]

# Compute the characteristics
peak_time, rise_time, settling_time, percentage_overshoot = compute_system_characteristics(numerator, denominator)

# Print the results
print(f"Peak Time: {peak_time:.4f} seconds")
print(f"Rise Time: {rise_time:.4f} seconds" if rise_time is not None else "Rise Time: Not found")
print(f"Settling Time: {settling_time:.4f} seconds" if settling_time is not None else "Settling Time: Not found")
print(f"Percentage Overshoot: {percentage_overshoot:.2f}%")

# Plot the step response
time, response = ctrl.step_response(ctrl.TransferFunction(numerator, denominator))
plt.plot(time, response)
plt.title('Step Response')
plt.xlabel('Time (seconds)')
plt.ylabel('Response')
plt.grid(True)
plt.show()
