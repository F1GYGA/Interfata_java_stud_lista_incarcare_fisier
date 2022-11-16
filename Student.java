

public class Student implements Comparable<Student>{
    private String nume, prenume;
    private int prezenta;

    public Student(String nume, String prenume,int prezenta) {
        this.nume = nume;
        this.prenume = prenume;
        this.prezenta = prezenta;
    }

@Override
    public int compareTo(Student deComparat){
        if (prezenta > deComparat.getPrezenta()){
            return 1;
        }else {
            if (prezenta < deComparat.getPrezenta()) {
                return -1;
            } else {
                return 0;
            }
    }
}
/*
    
    @Override
    public int comparCu(Comparabil deComparat) {
        Student s = (Student) deComparat;
        if (prezenta > s.getPrezenta()) {
            return 1;
        } else {
            if (prezenta < s.getPrezenta()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
*/

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getPrezenta() {
        return prezenta;
    }

    public void setPrezenta(int prezenta) {
        this.prezenta = prezenta;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nume + " " + prenume + " " + prezenta);
        return sb.toString();
    }


}