// Insertion sort in C++

#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
using std::cout; using std::cerr;
using std::endl; using std::string;
using std::ifstream; using std::vector;

// Function to print an array
void printArray(vector<int> array, int size) {
  	for (int i = 0; i < size; i++) {
		cout << array[i] << " ";
  	}
  	cout << endl;
}

void insertionSort(vector<int> array, int size) {
  	for (int step = 1; step < size; step++) {
		int key = array[step];
		int j = step - 1;

		// Compare key with each element on the left of it until an element smaller than
		// it is found.
		// For descending order, change key<array[j] to key>array[j].
    	while (key < array[j] && j >= 0) {
			array[j + 1] = array[j];
			--j;
    	}
    	array[j + 1] = key;
  	}
}

// Driver code
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

	// int data[] = {9, 5, 1, 4, 3};
	// int size = sizeof(data) / sizeof(data[0]);
	insertionSort(data, size);
	// cout << "Sorted array in ascending order:\n";
	printArray(data, size);
}
