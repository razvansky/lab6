package org.example;

public class Angajat {
    private String nume;
    private String post;
    private String data_angajarii;
    private float salar;
    public Angajat(){}
    public Angajat(String nume, String post, String data_angajare, float Salariu) {
        super();
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajare;
        this.salar = Salariu;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getData_angajarii() {
        return data_angajarii;
    }
    public void setData_angajarii(String data_angajarii) {
        this.data_angajarii = data_angajarii;
    }
    public float getSalar() {
        return salar;
    }
    public void setSalar(float salar) {
        this.salar = salar;
    }
    @Override
    public String toString() {
        return this.nume + "," + this.post + "," + this.data_angajarii + "," + this.salar;
    }
}
