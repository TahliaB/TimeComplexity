# TimeComplexity

This was my Calculus II Honors project involving a statistical analysis of the runtime of sorting algorithms in java. This was done in the first semester of my sophmore year (Spring 2022) before being formally introduced to time complexity, so I wanted to run an experiment where I could see how different algorithms with different runtimes work before starting my Data Structures course in the Fall semester.

I chose to use four different sorting algorithms: insertion sort, selection sort, bubble sort, and merge sort. I should have chosen algorithms with more variation in their time complexity, but I wanted to chose algorithms that I understood (which meant no recursion, except for merge sort since I wanted to have something with drastically different runtime).

To run the experiment, I set a variable with the desired filesize, then created a file with randomly-generated numbers of that filesize. As I had not yet been introduced to data structures, I used arrays to store all values. I read in the file, and stored the data in four different arrays for each sorting algorithm.

Then, I used System.currentTimeMillis() to keep track of elapsed time, and I ran each algorithm. I then wrote the sorted data to a file to ensure it was sorted properly, then wrote the time in milliseconds to sort the data to a separate file (the elapsed time did not include the time it took for file I/O).

The experiment was repeated a fixed number of times for several different filesizes to show the inefficiency of insertion sort, selection sort, and bubble sort, as well as the stark difference in merge sort's runtime.
