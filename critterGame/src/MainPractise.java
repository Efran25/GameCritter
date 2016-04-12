import java.util.ArrayList;

public class MainPractise implements Cloneable {

    public static void main(String[] args) {

        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        unsortedArray.add(2);
        unsortedArray.add(8);
        unsortedArray.add(6);
        unsortedArray.add(3);
        unsortedArray.add(12);
        unsortedArray.add(4);
        unsortedArray.add(7);

        QuickSort qsu = new QuickSort(unsortedArray);

        System.out.println("---------Initial Unsorted Array---------");
        for(int i:qsu.getSortedArray()){
            System.out.print(i+" ");
        }

        qsu.startQuickStart(0, unsortedArray.size()-1);


        System.out.println("\n\n---------Processed sorted Array---------");
        for(int i:qsu.getSortedArray()){
            System.out.print(i+" ");
        }
    }
}