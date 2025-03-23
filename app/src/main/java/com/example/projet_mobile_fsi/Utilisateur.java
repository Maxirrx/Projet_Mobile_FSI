package com.example.projet_mobile_fsi;

public class Utilisateur {
        private int id;
        private String nomUti;
        private String prenomUti;
        private String adresseUti;
        private String mailUti;
        private String nomMA;
        private String prenomMA;
        private String telMA;
        private String mailMA;
        private String nomEnt;
        private String adresseEnt;
        private String telEnt;
        private String mailEnt;
        private String libBil1;
        private double notBil1;
        private String remarqueBil1;
        private double noteEntBil1;
        private double noteOralBil1;
        private String dateBil1;
        private String maclasse;
        private double noteBil2;
        private double noteOralBil2;
        private String sujMemoire;
        private String dateBil2;

        public Utilisateur() {

    }

    public Utilisateur(int id, String nomUti, String prenomUti, String adresseUti, String mailUti, String nomMA, String prenomMA,  String telMA, String mailMA, String nomEnt, String adresseEnt, String telEnt,String mailEnt,  String libBil1, double notBil1, String remarqueBil1, double noteEntBil1, double noteOralBil1, String dateBil1, String maclasse, double noteBil2, double noteOralBil2, String sujMemoire, String dateBil2) {
        this.id = id;
        this.nomUti = nomUti;
        this.prenomUti = prenomUti;
        this.adresseUti = adresseUti;
        this.mailUti = mailUti;
        this.nomMA = nomMA;
        this.prenomMA = prenomMA;
        this.telMA = telMA;
        this.mailMA = mailMA;
        this.nomEnt = nomEnt;
        this.adresseEnt = adresseEnt;
        this.telEnt = telEnt;
        this.mailEnt = mailEnt;
        this.libBil1 = libBil1;
        this.notBil1 = notBil1;
        this.remarqueBil1 = remarqueBil1;
        this.noteEntBil1 = noteEntBil1;
        this.noteOralBil1 = noteOralBil1;
        this.dateBil1 = dateBil1;
        this.maclasse = maclasse;
        this.noteBil2 = noteBil2;
        this.noteOralBil2 = noteOralBil2;
        this.sujMemoire = sujMemoire;
        this.dateBil2 = dateBil2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUti() {
        return nomUti;
    }

    public void setNomUti(String nomUti) {
        this.nomUti = nomUti;
    }

    public String getAdresseUti() {
        return adresseUti;
    }

    public void setAdresseUti(String adresseUti) {
        this.adresseUti = adresseUti;
    }

    public String getPrenomUti() {
        return prenomUti;
    }

    public void setPrenomUti(String prenomUti) {
        this.prenomUti = prenomUti;
    }

    public String getMailUti() {
        return mailUti;
    }

    public void setMailUti(String mailUti) {
        this.mailUti = mailUti;
    }

    public String getNomMA() {
        return nomMA;
    }

    public void setNomMA(String nomMA) {
        this.nomMA = nomMA;
    }

    public String getPrenomMA() {
        return prenomMA;
    }

    public void setPrenomMA(String prenomMA) {
        this.prenomMA = prenomMA;
    }

    public String getTelMA() {
        return telMA;
    }

    public void setTelMA(String telMA) {
        this.telMA = telMA;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public void setNomEnt(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public String getMailMA() {
        return mailMA;
    }

    public void setMailMA(String mailMA) {
        this.mailMA = mailMA;
    }

    public String getAdresseEnt() {
        return adresseEnt;
    }

    public void setAdresseEnt(String adresseEnt) {
        this.adresseEnt = adresseEnt;
    }

    public String getTelEnt() {
        return telEnt;
    }

    public void setTelEnt(String telEnt) {
        this.telEnt = telEnt;
    }

    public String getMailEnt() {
        return mailEnt;
    }

    public void setMailEnt(String mailEnt) {
        this.mailEnt = mailEnt;
    }

    public String getLibBil1() {
        return libBil1;
    }

    public void setLibBil1(String libBil1) {
        this.libBil1 = libBil1;
    }

    public String getRemarqueBil1() {
        return remarqueBil1;
    }

    public void setRemarqueBil1(String remarqueBil1) {
        this.remarqueBil1 = remarqueBil1;
    }

    public double getNotBil1() {
        return notBil1;
    }

    public void setNotBil1(double notBil1) {
        this.notBil1 = notBil1;
    }

    public double getNoteEntBil1() {
        return noteEntBil1;
    }

    public void setNoteEntBil1(double noteEntBil1) {
        this.noteEntBil1 = noteEntBil1;
    }

    public double getNoteOralBil1() {
        return noteOralBil1;
    }

    public void setNoteOralBil1(double noteOralBil1) {
        this.noteOralBil1 = noteOralBil1;
    }

    public String getmaclasse() {
        return maclasse;
    }

    public void setmaclasse(String maclasse) {
        this.maclasse = maclasse;
    }

    public String getDateBil1() {
        return dateBil1;
    }

    public void setDateBil1(String dateBil1) {
        this.dateBil1 = dateBil1;
    }

    public double getNoteBil2() {
        return noteBil2;
    }

    public void setNoteBil2(double noteBil2) {
        this.noteBil2 = noteBil2;
    }

    public double getNoteOralBil2() {
        return noteOralBil2;
    }

    public void setNoteOralBil2(double noteOralBil2) {
        this.noteOralBil2 = noteOralBil2;
    }

    public String getSujMemoire() {
        return sujMemoire;
    }

    public void setSujMemoire(String sujMemoire) {
        this.sujMemoire = sujMemoire;
    }

    public String getDateBil2() {
        return dateBil2;
    }

    public void setDateBil2(String dateBil2) {
        this.dateBil2 = dateBil2;
    }
}
