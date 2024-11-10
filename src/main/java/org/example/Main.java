package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(List<Angajat> lista){
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire(){
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Angajat> lista = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return lista;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Angajat> listaAngajat = citire();
        List<Angajat> listapct3 = new ArrayList<Angajat>();
        Scanner scanner = new Scanner(System.in);
        int x;
        while(true)
        {
            System.out.println("1.Afisare lista");
            System.out.println("2.Afisare angajati peste 2500");
            System.out.println("3.creare lista din aprilie anu trecut");
            System.out.println("4.care nu sunt sefi salar descresc");
            System.out.println("5.nume angajati majuscule afisare");
            System.out.println("6. salarii mai mici de 3000");
            x=scanner.nextInt();
            switch(x)
            {
                case 1: {
                    for(Angajat angajat : listaAngajat)
                    {
                        System.out.println(angajat);
                    }
                    break;
                }
                case 2: {
                    for(Angajat angajat : listaAngajat) {
                        if(angajat.getSalar()>2500)
                        {
                            System.out.println(angajat);
                        }
                    }
                    break;
                }
                case 3:{
                    String an;
                    int ani= LocalDate.now().getYear()-1;
                    an = String.valueOf(ani);
                    listapct3 = new ArrayList<Angajat>();
                    for(Angajat angajat : listaAngajat) {
                        String split[]=angajat.getData_angajarii().split("-");
                        if(split[0].equals(an))
                        {
                            if(split[1].equals("04"))
                            {
                                if(angajat.getPost().contains("sef")||angajat.getPost().contains("director")) {
                                    listapct3.add(angajat);
                                }
                            }
                        }

                    }
                    for(Angajat angajat : listapct3) {
                        System.out.println(angajat);
                    }
                    break;
                }
                case 4:
                {
                    List<Angajat> angajatiFaraFunctieConducere = listaAngajat.stream()
                            .filter(angajat -> !angajat.getPost().toLowerCase().contains("sef") &&
                                    !angajat.getPost().toLowerCase().contains("director"))
                            .sorted(Comparator.comparingDouble(Angajat::getSalar).reversed())
                            .collect(Collectors.toList());
                    for(Angajat angajat: angajatiFaraFunctieConducere) {
                        System.out.println(angajat);
                    }
                    break;
                }
                case 5:
                {
                    List<String> numeAngajatiMajuscule = listaAngajat.stream()
                            .map(angajat -> angajat.getNume().toUpperCase())
                            .collect(Collectors.toList());

                    numeAngajatiMajuscule.forEach(System.out::println);
                    break;
                }
                case 6:
                {
                    List<Angajat> angajaticv = listaAngajat.stream().filter(angajat -> angajat.getSalar() < 3000).collect(Collectors.toList());
                    angajaticv.forEach(angajat -> System.out.println(angajat.getSalar()));

                    break;
                }
                case 7:
                {
                    break;
                }
                default: {break;}

            }
        }

    }
}