import mplcursors
import tkinter as tk
import numpy as np
import matplotlib.pyplot as plt
from scipy import signal

class PerformanceIndicesCalculator:
    def __init__(self, master):
        self.master = master
        self.master.title("Performance Indices Calculator")

        self.num_entry_label = tk.Label(master, text="Numerator Coefficients:")
        self.num_entry_label.grid(row=0, column=0, padx=10, pady=5)
        self.num_entry = tk.Entry(master)
        self.num_entry.grid(row=0, column=1, padx=10, pady=5)

        self.denom_entry_label = tk.Label(master, text="Denominator Coefficients:")
        self.denom_entry_label.grid(row=1, column=0, padx=10, pady=5)
        self.denom_entry = tk.Entry(master)
        self.denom_entry.grid(row=1, column=1, padx=10, pady=5)

        self.calc_button = tk.Button(master, text="Calculate", command=self.calculate)
        self.calc_button.grid(row=2, columnspan=2, padx=10, pady=5)

        self.results_label = tk.Label(master, text="")
        self.results_label.grid(row=3, columnspan=2, padx=10, pady=5)

        self.plot_button = tk.Button(master, text="Plot Response", command=self.plot_response)
        self.plot_button.grid(row=4, columnspan=2, padx=10, pady=5)

    def calculate(self):
        try:
            num_coeffs = list(map(float, self.num_entry.get().split(',')))
            denom_coeffs = list(map(float, self.denom_entry.get().split(',')))

            # Calculate dominant poles
            poles = np.roots(denom_coeffs)

            if len(poles) > 0:
                # Natural frequency and damping ratio
                omega_n = np.abs(np.imag(poles[0]))
                damping_ratio = -np.real(poles[0]) / omega_n

                # Performance indices
                rise_time = (np.pi - np.angle(poles[0])) / (omega_n * np.sqrt(1 - damping_ratio**2))
                peak_time = np.pi / (omega_n * np.sqrt(1 - damping_ratio**2))
                max_overshoot = np.exp(-damping_ratio * np.pi / np.sqrt(1 - damping_ratio**2)) * 100
                settling_time_2_percent = -np.log(0.02) / (damping_ratio * omega_n)
                settling_time_5_percent = -np.log(0.05) / (damping_ratio * omega_n)
                
                result_str = f"Rise Time: {rise_time:.2f} sec\nPeak Time: {peak_time:.2f} sec\nMax Overshoot: {max_overshoot:.2f}%\nSettling Time (2%): {settling_time_2_percent:.2f} sec\nSettling Time (5%): {settling_time_5_percent:.2f} sec"
                self.results_label.config(text=result_str)
            else:
                self.results_label.config(text="No poles found")
        except Exception as e:
            self.results_label.config(text="Error: Invalid input")

    
    def plot_response(self):
        try:
            num_coeffs = list(map(float, self.num_entry.get().split(',')))
            denom_coeffs = list(map(float, self.denom_entry.get().split(',')))

            system = signal.TransferFunction(num_coeffs, denom_coeffs)
            t, y = signal.step(system)

            plt.figure()
            plt.plot(t, y, label='Step Response')
            plt.title('Step Response')
            plt.xlabel('Time')
            plt.ylabel('Output')
            plt.grid(True)

            # Performance indices
            indices = self.calculate_indices(num_coeffs, denom_coeffs)

            for index_name, index_value in indices.items():
                if index_name == 'Rise Time':
                    plt.axvline(x=index_value, color='r', linestyle='--', label='Rise Time')
                    plt.scatter(index_value, np.interp(index_value, t, y), color='r', label='Rise Time Intersection')
                    plt.text(index_value, plt.ylim()[1] * 0.3, f'{index_name}: {index_value:.2f}', color='r', rotation=90)
                    plt.text(index_value, np.interp(index_value, t, y), f'({index_value:.2f}, {np.interp(index_value, t, y):.2f})', color='r', ha='right', va='bottom')
                elif index_name == 'Peak Time':
                    plt.axvline(x=index_value, color='g', linestyle='--', label='Peak Time')
                    plt.scatter(index_value, np.interp(index_value, t, y), color='g', label='Peak Time Intersection')
                    plt.text(index_value, plt.ylim()[1] * 0.3, f'{index_name}: {index_value:.2f}', color='g', rotation=90)
                    plt.text(index_value, np.interp(index_value, t, y), f'({index_value:.2f}, {np.interp(index_value, t, y):.2f})', color='g', ha='right', va='bottom')
                elif index_name == 'Settling Time (2%)':
                    plt.axvline(x=index_value, color='b', linestyle='--', label='Settling Time (2%)')
                    plt.scatter(index_value, np.interp(index_value, t, y), color='b', label='Settling Time (2%) Intersection')
                    plt.text(index_value, plt.ylim()[1] * 0.3, f'{index_name}: {index_value:.2f}', color='b', rotation=90)
                    plt.text(index_value, np.interp(index_value, t, y), f'({index_value:.2f}, {np.interp(index_value, t, y):.2f})', color='b', ha='right', va='bottom')
                elif index_name == 'Settling Time (5%)':
                    plt.axvline(x=index_value, color='m', linestyle='--', label='Settling Time (5%)')
                    plt.scatter(index_value, np.interp(index_value, t, y), color='m', label='Settling Time (5%) Intersection')
                    plt.text(index_value, plt.ylim()[1] * 0.3, f'{index_name}: {index_value:.2f}', color='m', rotation=90)
                    plt.text(index_value, np.interp(index_value, t, y), f'({index_value:.2f}, {np.interp(index_value, t, y):.2f})', color='m', ha='right', va='bottom')
                elif index_name == 'Max Overshoot':
                    plt.axhline(y=index_value, color='c', linestyle='--', label='Max Overshoot')
                    plt.scatter(np.interp(index_value, y, t), index_value, color='c', label='Max Overshoot Intersection')
                    plt.text(t[-1] * 0.8, index_value, f'{index_name}: {index_value:.2f}%', color='c')
                    plt.text(np.interp(index_value, y, t), index_value, f'({np.interp(index_value, y, t):.2f}, {index_value:.2f}%)', color='c', ha='right', va='bottom')

            plt.legend()
            mplcursors.cursor(hover=True)
            plt.show()
        except Exception as e:
            self.results_label.config(text="Error: Invalid input")



    def calculate_indices(self, num_coeffs, denom_coeffs):
        poles = np.roots(denom_coeffs)

        indices = {}
        if len(poles) > 0:
            omega_n = np.abs(np.imag(poles[0]))
            damping_ratio = -np.real(poles[0]) / omega_n

            # Performance indices calculation
            indices['Rise Time'] = (np.pi - np.angle(poles[0])) / (omega_n * np.sqrt(1 - damping_ratio**2))
            indices['Peak Time'] = np.pi / (omega_n * np.sqrt(1 - damping_ratio**2))
            indices['Max Overshoot'] = np.exp(-damping_ratio * np.pi / np.sqrt(1 - damping_ratio**2)) * 100
            indices['Settling Time (2%)'] = -np.log(0.02) / (damping_ratio * omega_n)
            indices['Settling Time (5%)'] = -np.log(0.05) / (damping_ratio * omega_n)

        return indices

def main():
    root = tk.Tk()
    app = PerformanceIndicesCalculator(root)
    root.mainloop()

if __name__ == "__main__":
    main()
