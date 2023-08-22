// Selection sort in C++

#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
using std::cout; using std::cerr;
using std::endl; using std::string;
using std::ifstream; using std::vector;

// function to swap the the position of two elements
void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

// function to print an array
void printArray(vector<int> array, int size) {
	for (int i = 0; i < size; i++) {
		cout << array[i] << " ";
	}
	cout << endl;
}

void selectionSort(vector<int> array, int size) {
	for (int step = 0; step < size - 1; step++) {
		int min_idx = step;
		for (int i = step + 1; i < size; i++) {

			// To sort in descending order, change > to < in this line.
			// Select the minimum element in each loop.
			if (array[i] < array[min_idx])
				min_idx = i;
		}

	// put min at the correct position
	swap(&array[min_idx], &array[step]);
  	}
}

// driver code
int main() {
    string filename("input.txt");
    int n;
	int size;
    vector<int> data;

    ifstream input_file(filename);
    if (!input_file.is_open()) {
        cerr << "Could not open the file - '"
             << filename << "'" << endl;
        return EXIT_FAILURE;
    }

	input_file >> size;
    while (input_file >> n) {
		data.push_back(n);
    }

    input_file.close();

	// int data[] = {20, 12, 10, 15, 2};
	// int size = sizeof(data) / sizeof(data[0]);
	selectionSort(data, size);
	// cout << "Sorted array in Acsending Order:\n";
	printArray(data, size);

    return EXIT_SUCCESS;
}