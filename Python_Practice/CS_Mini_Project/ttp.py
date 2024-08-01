import numpy as np
import matplotlib.pyplot as plt
from scipy.signal import lti, step

def time_domain_specs(system):
    # Get the system's step response
    t, y = step(system)

    # Settling time: time taken for the response to remain within 2% of the final value
    settling_time = t[np.where(np.abs(y - 1) < 0.02)[0][0]]

    # Peak time: time at which the response reaches the first peak
    peak_time = t[np.argmax(y)]

    # Peak value: maximum value of the response
    peak_value = np.max(y)

    # Rise time: time taken for the response to rise from 10% to 90% of the final value
    rise_time_start = t[np.where(y > 0.1)[0][0]]
    rise_time_end = t[np.where(y > 0.9)[0][0]]
    rise_time = rise_time_end - rise_time_start

    # Delay time: time taken for the response to reach 50% of the final value
    delay_time = t[np.where(y > 0.5)[0][0]]

    print(f"Settling Time: {settling_time}")
    print(f"Peak Time: {peak_time}")
    print(f"Peak Value: {peak_value}")
    print(f"Rise Time: {rise_time}")
    print(f"Delay Time: {delay_time}")

    # Plotting the response
    plt.figure()
    plt.plot(t, y, label='Step Response')
    plt.axhline(1, color='r', linestyle='--', label='Final Value')
    plt.axvline(settling_time, color='g', linestyle='--', label='Settling Time')
    plt.axvline(peak_time, color='m', linestyle='--', label='Peak Time')
    plt.axvline(rise_time_start, color='b', linestyle='--', label='Rise Time Start')
    plt.axvline(rise_time_end, color='b', linestyle='--', label='Rise Time End')
    plt.axvline(delay_time, color='c', linestyle='--', label='Delay Time')
    plt.xlabel('Time (s)')
    plt.ylabel('Response')
    plt.legend()
    plt.title('Time Domain Specifications')
    plt.grid()
    plt.show()

# Define your system here, e.g., a second-order system with natural frequency 1 rad/s and damping ratio 0.5
system = lti([1], [1, 2*0.5, 1])

time_domain_specs(system)
