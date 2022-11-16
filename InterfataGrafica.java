import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import poo.util.*;
import java.util.*;

class InterfataGrafica extends JFrame {
    // declarari labels
    private JLabel labelNume = new JLabel("Nume:");
    private JLabel labelPrenume = new JLabel("Prenume:");
    private JLabel labelPrezenta = new JLabel("Prezenta:");
    private JLabel labelContinut = new JLabel("Continut lista studenti:");
    private JLabel labelEroare = new JLabel("");
    private JLabel labelTipEroare = new JLabel("Tip de eroare:");

    // declarari butoane
    private JButton buttonAdauga = new JButton("Adauga");
    private JButton buttonSterge = new JButton("Sterge");
    private JButton buttonSorteaza = new JButton("Sorteaza");
    private JButton buttonAdd = new JButton("Add");

    // declarari field text
    private JTextField textNume = new JTextField("", 10);
    private JTextField textPrenume = new JTextField("", 10);
    private JTextField textPrezenta = new JTextField("", 10);

    // declarari text areas
    private JTextArea textContinut = new JTextArea("", 10, 50);

    static ListaDeComparabile<Student> lista = new ListaDeComparabile<Student>(Student.class,6);

    public InterfataGrafica() throws IOException{
        textContinut.setText(lista.getStringElemente());

        buttonAdauga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eAdauga) { // cod pentru buton adauga
                String id = ((JButton) eAdauga.getSource()).getText();

                if (id.equals("Adauga")) {
                    try {
                        labelEroare.setText("");
                        lista.adaugareElement(
                                new Student(textNume.getText(), textPrenume.getText(),
                                        Integer.parseInt(textPrezenta.getText())));
                        textContinut.setText(lista.getStringElemente());

                    } catch (ExceptieListaPlina stivaPlina) {
                        labelEroare.setText("Lista este plina");
                    }
                }
            }
        });

        buttonSterge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eSterge) { // cod pentur buton stergere
                String id = ((JButton) eSterge.getSource()).getText();
                if (id.equals("Sterge")) {
                    try {
                        labelEroare.setText("");
                        lista.eliminareElement();
                        textContinut.setText(lista.getStringElemente());
                    } catch (ExceptieListaGoala listaGoala) {
                        labelEroare.setText("Lista este goala");
                    }
                }
            }
        });
        buttonSorteaza.addActionListener(new ActionListener() { // cod pentru buton sorteaza
            public void actionPerformed(ActionEvent eSorteaza) {
                String id = ((JButton) eSorteaza.getSource()).getText();

                if (id.equals("Sorteaza")) {
                    try {

                        lista.sortareElemente();
                        textContinut.setText(lista.getStringElemente());

                    } catch (ExceptieListaGoala listavaGoala) {
                        labelEroare.setText("Lista este goala");
                    }

                }
            }
        });
        buttonAdd.addActionListener(new ActionListener() { // cod pentru buton add
            public void actionPerformed(ActionEvent eAdd) {
                PrintWriter outputStream = null;
                try {
                    try {
                        outputStream = new PrintWriter(("Studenti.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String listaOut = lista.getStringElemente();
                    outputStream.print(listaOut);
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            }
        });

        // labels Nume prenume si prezenta
        Box bhNume = Box.createHorizontalBox();
        bhNume.add(labelNume);
        bhNume.add(Box.createHorizontalStrut(10));
        bhNume.add(textNume);
        bhNume.add(Box.createHorizontalStrut(10));
        bhNume.add(Box.createHorizontalGlue());

        Box bhTipEroare = Box.createHorizontalBox();
        bhTipEroare.add(Box.createHorizontalStrut(10));
        bhTipEroare.add(labelTipEroare);
        bhTipEroare.add(Box.createHorizontalStrut(10));
        bhTipEroare.add(Box.createHorizontalGlue());

        Box bhEroare = Box.createHorizontalBox();
        bhEroare.add(Box.createHorizontalStrut(10));
        bhEroare.add(labelEroare);
        bhEroare.add(Box.createHorizontalGlue());

        Box bhPrenume = Box.createHorizontalBox();
        bhPrenume.add(labelPrenume);
        bhPrenume.add(Box.createHorizontalStrut(10));
        bhPrenume.add(textPrenume);
        bhPrenume.add(Box.createHorizontalStrut(10));
        bhPrenume.add(Box.createHorizontalGlue());

        Box bhPrezenta = Box.createHorizontalBox();
        bhPrezenta.add(labelPrezenta);
        bhPrezenta.add(Box.createHorizontalStrut(10));
        bhPrezenta.add(textPrezenta);
        bhPrezenta.add(Box.createHorizontalStrut(10));
        bhPrezenta.add(Box.createHorizontalGlue());

        // sectiune afisare studenti
        Box bhText = Box.createHorizontalBox();
        bhText.add(labelContinut);
        bhText.add(Box.createHorizontalStrut(10));
        bhText.add(Box.createHorizontalGlue());

        Box bhAfisareText = Box.createHorizontalBox();
        bhAfisareText.add(textContinut);
        bhAfisareText.add(Box.createHorizontalStrut(10));
        bhAfisareText.add(Box.createHorizontalGlue());

        // lipire sectiuni nume prenume prezenta + textarea
        Box bv1 = Box.createVerticalBox();
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhNume);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhPrenume);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhPrezenta);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhText);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(bhAfisareText);
        bv1.add(Box.createVerticalStrut(10));
        bv1.add(Box.createVerticalGlue());

        // butoane
        // butonul adauga
        Box bhAdauga = Box.createVerticalBox();
        bhAdauga.add(Box.createVerticalStrut(10));
        bhAdauga.add(buttonAdauga);
        bhAdauga.add(Box.createVerticalGlue());

        // butonul2 sterge
        Box bhSterge = Box.createVerticalBox();
        bhSterge.add(Box.createVerticalStrut(10));
        bhSterge.add(buttonSterge);
        bhSterge.add(Box.createVerticalGlue());

        // butonul sorteaza
        Box bhSorteaza = Box.createVerticalBox();
        bhSorteaza.add(Box.createVerticalStrut(10));
        bhSorteaza.add(buttonSorteaza);
        bhSorteaza.add(Box.createVerticalGlue());

        // butonul add
        Box bhAdd = Box.createVerticalBox();
        bhSorteaza.add(Box.createVerticalStrut(10));
        bhSorteaza.add(buttonAdd);
        bhSorteaza.add(Box.createVerticalGlue());

        // lipire butoane intre ele
        Box bv2 = Box.createVerticalBox();
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhAdauga);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhSterge);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhSorteaza);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhAdd);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(bhTipEroare);
        bv2.add(bhEroare);
        bv2.add(Box.createVerticalStrut(10));
        bv2.add(Box.createVerticalGlue());

        // concatenarea elementelor verticale
        Box bh6 = Box.createHorizontalBox();
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(bv1);
        bh6.add(Box.createHorizontalStrut(50));
        bh6.add(bv2);
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(Box.createHorizontalStrut(10));
        bh6.add(Box.createHorizontalGlue());

        Container cp = getContentPane();
        cp.add(BorderLayout.CENTER, bh6);

    }

    public static void main(String[] args) throws IOException, ExceptieListaPlina {

        // citirea din fisier
        BufferedReader inputStream = null;
        Scanner readVar = null;
        try {
            inputStream = new BufferedReader(new FileReader("Studenti.txt"));
            String termenExtras;
            while ((termenExtras = inputStream.readLine()) != null) {
                readVar = new Scanner(termenExtras);
                lista.adaugareElement(new Student(readVar.next(), readVar.next(), Integer.parseInt(readVar.next())));
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (readVar != null) {
                readVar.close();
            }
        }

        InterfataGrafica ig = new InterfataGrafica();

        ig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ig.setSize(500, 250);

        ig.setVisible(true);

    }
}