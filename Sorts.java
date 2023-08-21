import java.util.Random;
import java.util.ArrayList;

public class Sorts
{

	public int[] SelectionSort(int[] arr)
	{
		//long t = System.nanoTime(); // nanosek 

		for(int i = 0; i < arr.length-1; i++)
		{
			int s = i;
			for (int j = i+1; j < arr.length; j++) 
			{
				if(arr[j] < arr[s])
				{
					s = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[s];
			arr[s] = tmp;
		}

		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);
		return arr;
	}

	public int[] InsertionSort(int[] arr)
	{
		//long t = System.nanoTime(); // nanosek
		for(int i = 1; i < arr.length; i++)
		{
			int x = arr[i];
			int j = i;
			while(j > 0 && x < arr[j-1])
			{
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j] = x;
		}
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);
		return arr;
	}

	public int generateRandomIntInRange(int l, int h)
	{
		Random r = new Random();
		int result = r.nextInt(h-l) + l;
		return result;
	}

	public int inPlacePartition(int[] arr, int a, int b)
	{

		int r = generateRandomIntInRange(a,b);
		int tmp = arr[r];
		arr[r] = arr[b];
		arr[b] = tmp;

		int p = arr[b];
		int l = a;
		r = b - 1;

		while(l <= r)
		{
			while(l <= r && arr[l] <= p)
			{
				l = l + 1;
			}
			while(r >= l && arr[r] >= p)
			{
				r = r - 1;
			}
			if(l < r)
			{
				tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
			}
		}
		tmp = arr[l];
		arr[l] = arr[b];
		arr[b] = tmp; 
		return l;
	}

	// public int[] inPlaceQuickSort(int[] arr, int a, int b)
	// {
	// 	if(a >= b)
	// 	{
	// 		return null;
	// 	}
	// 	int l = inPlacePartition(arr, a, b);
	// 	inPlaceQuickSort(arr, a, (l - 1));
	// 	inPlaceQuickSort(arr, l+1, b);
	// 	return arr;
	// }

	public int[] CorrectInPlaceQuickSort(int[] arr, int a, int b)
	{
		while(a < b)
		{
			int l = inPlacePartition(arr, a, b);
			if((l - a) < (b - l))
			{
				CorrectInPlaceQuickSort(arr, a, (l - 1));
				a = l + 1;
			}
			else
			{
				CorrectInPlaceQuickSort(arr, l+1, b);
				b = l - 1;
			}
		}
		return arr;
	}

	public int[] quickSort(int[] arr)
	{
		//long t = System.nanoTime(); // nanosek
		int[] resultat = CorrectInPlaceQuickSort(arr,1,arr.length-1);
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);
		return resultat;
	}

 public int[] bucketSort(int[] arr)
    {
        int length = arr.length;
        if(length == 1)
            return arr;
        int bigNr = arr[0];
        int minNr = arr[0];
        int arrIndex = 0;

        for(int i = 0; i < length; i++)
        {
            if(bigNr < arr[i])
            {
                bigNr = arr[i];
            }
            else if(minNr > arr[i])
            {
                minNr = arr[i];
            }
        }
        Bucket[] b = new Bucket[bigNr-minNr+1];     

        for(int key, x = 0; x < length; x++)
        {
            key = arr[x]-minNr;
            if(b[key] == null)
            {
                b[key] = new Bucket();
            }
            b[key].addValue(arr[x]);
        }

        for(int i = 0; i < b.length; i++)
        {
            if(b[i] != null)
            {
                for (int x : b[i].getBucket()) 
                {
                    arr[arrIndex] = x;
                    arrIndex++;
                }
            }
        }
        return arr;
    }

	private class Bucket
	{
		ArrayList<Integer> bucket;

		private Bucket()
		{
			bucket = new ArrayList<Integer>();
		}

		public void addValue(int value)
		{
			bucket.add(value);
		}

		public int getValue()
		{
		    return bucket.remove(0);
		}

		public ArrayList<Integer> getBucket()
		{
			return bucket;
		}
	}

}