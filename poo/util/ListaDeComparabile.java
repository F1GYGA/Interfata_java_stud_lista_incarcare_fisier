package poo.util;

public class ListaDeComparabile<T extends Comparable>{

    T[] elemente;
    int nrCurentElemente;

    public ListaDeComparabile(Class <T> _itemClassType,int dimLista) {
        elemente = (T[]) java.lang.reflect.Array.newInstance(_itemClassType, dimLista);
        nrCurentElemente = 0;
    }
   
    public void afisareElemente() {
        if (nrCurentElemente == 0)
            System.out.println("Nu sunt elemente in lista");
        else {
            for (int i = nrCurentElemente - 1; i >= 0; i--) {
                System.out.println(elemente[i] + " ");
            }
        }
    }

    public void adaugareElement(T elementDeInserat) throws ExceptieListaPlina { //
        if (nrCurentElemente >= elemente.length) {
            throw new ExceptieListaPlina();
        } else {

            nrCurentElemente += 1;
            elemente[nrCurentElemente- 1] =  elementDeInserat;
            

            System.out.println("S-a introdus elementul " + elementDeInserat + " , numar total de elemente: "
                    + nrCurentElemente);
        }
    }

    public int verificareLista() {
        if (nrCurentElemente == 0)
            return 0;
        else
            return 1;
    }

    public T eliminareElement() {
        if (nrCurentElemente == 0) {
            throw new ExceptieListaGoala();
        } else {
            T copieElementExtras = elemente[0];
            for (int i = 0; i < nrCurentElemente - 1; i++) { // se muta elementele la stanga
                elemente[i] = elemente[i + 1];
            }
            nrCurentElemente -= 1;
            return copieElementExtras;
        }
    }

    public void sortareElemente() {
        if (nrCurentElemente == 0) {
            throw new ExceptieListaGoala();
        } else {
            for (int i = 0; i < nrCurentElemente; i++) { // sortare descrescatoare prin metoda bubble sort
                for (int j = 0; j < nrCurentElemente - i - 1; j++) {
                    if (( elemente[j]).compareTo(elemente[j + 1]) < 0) {
                        T auxVar = elemente[j];
                        elemente[j] = elemente[j + 1];
                        elemente[j + 1] = auxVar;
                    }
                }
            }
            System.out.println("A avut loc sortarea listei in mod descrescator");
        }
    }

    public Object getElement(int i) {
        return elemente[i];
    }

    public String getStringElemente() {

        String listaStudenti = "";

        for (int i = 0; i < nrCurentElemente; i++) {
            listaStudenti += elemente[i];
            listaStudenti += "\r\n";
        }

        return listaStudenti;
    }

    public int getElementeCurente() {
        return nrCurentElemente;
    }

    public void setElemente(T[] elemente) {
        this.elemente = elemente;
    }

    @Override
    public String toString() {

        String sb = "";
        for (int i = nrCurentElemente - 1; i >= 0; i--) {
            sb += (elemente[i] + "\n");
        }
        System.out.println(sb);
        return sb;
    }
}
