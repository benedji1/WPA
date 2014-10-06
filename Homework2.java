
interface InterSearch {
    /* Požitím interpolačního hledání vrátí index prvku what nalezeného mezi indexy first a last
     pole data nebo -1, pokud tam není. Metoda bude rekurzivní a měla by být odolná vůči chybně 
     zadaným parametrům. Pro zaokrouhlování na celá čísla použijte metodu Math.round(). */

}

public class Homework2 implements InterSearch {

    @Override
    public int search(int first, int last, int what, int[] data) {
        if (first > last || first < 0 || last > data.length || data[last] < what || data[first] > what) {
            return -1;
        }
        if (data[first] == what) {
            return first;
        } else if (first == last) {
            return -1;
        }
        int mid = first + Math.round((((float) last - first) / (data[last] - data[first])) * (what - data[first]));
        if (mid < 0 || mid >= data.length) {
            return -1;
        }
        if (data[mid] == what) {
            System.out.println(what + " " + data[mid]);
            return mid;
        } else if (data[mid] < what) {
            return search(mid + 1, last, what, data);
        } else {
            return search(first, mid - 1, what, data);
        }
    }
}
