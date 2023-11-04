package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Spill.Hangman();

    }
}


class Spill{



    public static void Hangman(){



        boolean spilletKjører = true;


        String ut = "";



        int AntallFeil = 0;

        ArrayList<String> ordetMedSpesifikkePlasser = new ArrayList<>();


        ordetMedSpesifikkePlasser.add("U");
        ordetMedSpesifikkePlasser.add("N");
        ordetMedSpesifikkePlasser.add("I");
        ordetMedSpesifikkePlasser.add("V");
        ordetMedSpesifikkePlasser.add("E");
        ordetMedSpesifikkePlasser.add("R");
        ordetMedSpesifikkePlasser.add("S");
        ordetMedSpesifikkePlasser.add("I");
        ordetMedSpesifikkePlasser.add("T");
        ordetMedSpesifikkePlasser.add("Y");



        ArrayList<String> UnngåGjentakelseAvSammeOrd = new ArrayList<>();


        while (spilletKjører) {

            String VelgBokstav = JOptionPane.showInputDialog("");

            boolean correctGuess = false;



            for (int i = 0; i < ordetMedSpesifikkePlasser.size(); i++) { //Runs through the complete word


                //If the letter matches the letter which the user types in, it will show it
                if (VelgBokstav.equalsIgnoreCase(ordetMedSpesifikkePlasser.get(i))) {


                    //If the arraylist dosen't already contain specific letters from the arrayList containing the word, only then it will be added inside it
                    if (!UnngåGjentakelseAvSammeOrd.contains(ordetMedSpesifikkePlasser.get(i))) {
                        UnngåGjentakelseAvSammeOrd.add(ordetMedSpesifikkePlasser.get(i));
                    }
                    correctGuess = true;

                }
            }


                    if (correctGuess) {
                        System.out.println();

                        for (String skrivut : ordetMedSpesifikkePlasser) {


                            //Write out the arrayList containing the word only if the specific elements from the other arraylist matches it
                            //So that only those specific letters will be written out
                            if (UnngåGjentakelseAvSammeOrd.contains(skrivut)) {
                                System.out.print(skrivut);

                            }


                            //When the specific letters are written out, the specific positions are also written out, so
                            // This ensures there are lines which fill out the empty spaces where the arraylist isn't filled out
                            else {
                                System.out.print("_");}

                        }
                    }


                    //else if the correctGuess = false:
                    else {


                        AntallFeil++; //Counting amount of mistakes to use it to build the hangman body

                        //Building the hangman body:

                        if (AntallFeil == 1){
                            System.out.println();
                            ut+=" o\n";
                            JOptionPane.showMessageDialog(null, ut);
                        }

                       else if (AntallFeil==2){
                            System.out.println();
                            ut+= "-";

                            JOptionPane.showMessageDialog(null, ut);
                        }

                        else if (AntallFeil == 3){
                            System.out.println();
                            ut+= "|";

                            JOptionPane.showMessageDialog(null, ut);
                        }

                        else if (AntallFeil == 4){
                            System.out.println();
                            ut+= "-\n";

                            JOptionPane.showMessageDialog(null, ut);
                        }




                        else if (AntallFeil == 5){
                            System.out.println();
                            ut+= "| ";

                            JOptionPane.showMessageDialog(null, ut);
                        }

                        else {
                            System.out.println();
                            ut+= "|";

                            System.out.println(ut);

                            JOptionPane.showMessageDialog(null, ut);
                            JOptionPane.showMessageDialog(null, "6 mistakes, you lost -:(");
                            UnngåGjentakelseAvSammeOrd.clear();
                            spilletKjører = false;
                        }
                    }




            //If the complete word inside ordetMedSpesifikkePlasser is inside UnngåGjentakelseAvSammeOrd, then the game will stop
            if (UnngåGjentakelseAvSammeOrd.containsAll(ordetMedSpesifikkePlasser)){
                JOptionPane.showMessageDialog(null, "Congratulations, you have guessed the word!");
                UnngåGjentakelseAvSammeOrd.clear();
                spilletKjører = false;}
                }


            }


        }











