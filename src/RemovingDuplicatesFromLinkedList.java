import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class RemovingDuplicatesFromLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> ls = new LinkedList();
		ls.add(2);
		ls.add(3);
		ls.add(4);
		ls.add(3);
		ls.add(2);
		ls.add(5);
		ls.add(7);
		ls.add(2);
		
		for(Integer i : ls)
		{
			System.out.print(i+" ");
		}

		
		// one solution is we can direclty put list into hash set
/*		HashSet hs = new HashSet();
		hs.addAll(ls);
		
		System.out.println();
		for(Object i : hs)
		{
			System.out.print(i+" ");
		}
*/		
		
		
		ls = removeDuplicates(ls);
		//ls.remove(4);
		System.out.println();
		for(Integer i : ls)
		{
			System.out.print(i+" ");
		}
	}
	
	public static LinkedList removeDuplicates(LinkedList ls)
	{
		Iterator pointer1 = ls.iterator();
		Iterator pointer2 = ls.iterator();
		int p1=0,p2=0;
		
		while(pointer1.hasNext() )
		{
			int point2 = (int)pointer2.next();
			p2++;
			int point1 = (int) pointer1.next();
			//System.out.println(pointer1.hasNext()+"fvfffffffffffffffffffffffffffff");
			System.out.println("here");
			here:
			while(pointer2.hasNext())
			{
				
				//System.out.println(ls.get(pointer2));
				
				System.out.println(point1+"  "+point2);
				if(point1 == (point2=(int)pointer2.next()))
				{
					System.out.println(point1+"  "+point2);
					System.out.println("here in p1 "+ p1 +" p2 "+p2);	
					ls.remove(p2);
					//pointer2 = (Iterator) pointer2.next();
					//p2--;
					break here;
				}
				p2++;
			}
			p1++;
			p2 = p1;
			//pointer2 = pointer1;
		}
		
		return ls;
		
	}

}
