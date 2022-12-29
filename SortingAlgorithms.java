import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class SortingAlgorithms {
	public static void main(String[] args) throws IOException
	{
		int filesize = 50000;
		
		int[] mdata = createRandom(filesize);
		int[] bdata = new int[filesize];
		int[] sdata = new int[filesize];
		int[] idata = new int[filesize];
		for(int i = 0; i < mdata.length; i++)
		{
			bdata[i] = mdata[i];
			sdata[i] = mdata[i];
			idata[i] = mdata[i];
		}
		
		long startTime = System.currentTimeMillis();
		int[] i = insertionSort(filesize, idata);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Insertion Sort: " + elapsedTime + " ms");
		fileWrite("C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\insertionSort.txt", i);
		finalSortData(elapsedTime, "C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\insertionSortTime.txt");
		
		startTime = System.currentTimeMillis();
		int[] b = bubbleSort(filesize, bdata);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Bubble Sort: " + elapsedTime + " ms");
		fileWrite("C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\bubbleSort.txt", b);
		finalSortData(elapsedTime, "C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\bubbleSortTime.txt");
		
		startTime = System.currentTimeMillis();
		int[] s = selectionSort(filesize, sdata);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Selection Sort: " + elapsedTime + " ms");
		fileWrite("C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\selectionSort.txt", s);
		finalSortData(elapsedTime, "C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\selectionSortTime.txt");
		
		startTime = System.currentTimeMillis();
		int[] m = mergeSort(filesize, sdata);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Merge Sort: " + elapsedTime + " ms");
		fileWrite("C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\mergeSort.txt", m);
		finalSortData(elapsedTime, "C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\mergeSortTime.txt");

	}
	
	public static int[] createRandom(int filesize) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\tahli\\eclipse-workspace\\MATH2854 Honors Project\\src\\randomData.txt"));
		
		Random rand = new Random();

		// create randomized file
		String arr[] = new String[filesize];
		for(int i = 0; i < filesize; i++)
		{
			arr[i] = "" + rand.nextInt(1000000);
		}
		for(int i = 0; i < filesize; i++)
		{
			bw.write(arr[i]);
			bw.newLine();
		}
		
		// convert to int array
		int[] data = new int[filesize];
		for(int i = 0; i < data.length; i++)
		{
			data[i] = Integer.parseInt(arr[i]);
		}
		bw.close();
		return data;
	}
	
	public static int[] bubbleSort(int filesize, int[] bdata) throws IOException
	{
		for(int i = 0; i < bdata.length; i++)
		{
			for(int j = 0; j < bdata.length; j++)
			{
				if((j + 1) < bdata.length)
				{
					if(bdata[j] > bdata[j + 1])
					{
						int temp = bdata[j];
						bdata[j] = bdata[j + 1];
						bdata[j + 1] = temp;
					}
				}
			}
		}
		return bdata;
	}
	public static int[] selectionSort(int filesize, int[] sdata) throws IOException
	{
		for (int i = 0; i < sdata.length - 1; i++) {
	        int minElementIndex = i;
	        for (int j = i + 1; j < sdata.length; j++) {
	            if (sdata[minElementIndex] > sdata[j]) {
	                minElementIndex = j;
	            }
	        }

	        if (minElementIndex != i) {
	            int temp = sdata[i];
	            sdata[i] = sdata[minElementIndex];
	            sdata[minElementIndex] = temp;
	        }
	    }
		return sdata;
	}
	public static int[] insertionSort(int filesize, int[] idata) throws IOException
	{
		for(int i = 0; i < idata.length; i++)
		{
			for(int j = i + 1; j < idata.length; j++)
			{
				if(idata[j] < idata[i])
				{
					int temp = idata[j];
					idata[j] =  idata[i];
					idata[i] = temp;
				}
			}
		}
		return idata;
	}
	
	public static int[] mergeSort(int filesize, int[] mdata) throws IOException
	{
		
		if(mdata.length > 2)
		{
			int mid = mdata.length/2;
			int[] left = new int [mid];
			int[] right = new int[mdata.length - mid];
			for(int i = 0; i < mid; i++)
			{
				left[i] = mdata[i];
			}
			for(int i = mid; i < mdata.length; i++)
			{
				right[i - mid] = mdata[i];
			}
			mergeSort(filesize, left);
			mergeSort(filesize, right);
			
			merge(mdata,left,right);
		}
			return mdata;
	}
	
	public static void merge(int[] mdata, int[] left, int[] right)
	{
		int i = 0, j = 0, k = 0;
		
		while(i < left.length && j < right.length)
		{
			if(left[i] <= right[j])
			{
				mdata[k] = left[i];
				i++;
			}
			else
			{
				mdata[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < left.length)
		{
			mdata[k] = left[i];
			i++;
			k++;
		}
		
		while(j < right.length)
		{
			mdata[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void fileWrite(String filename, int[] arr) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		for(int i = 0; i < arr.length; i++)
		{
			bw.write("" + arr[i]);
			bw.newLine();
		}
		bw.close();
	}
	
	public static void finalSortData(long time, String filename) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
		
		bw.write("" + time);
		bw.newLine();
		
		bw.close();
	}
}
