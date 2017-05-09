package com.example.ajmalsyed.pets_app;

/**
 * Created by Ajmal Syed on 4/5/2017.
 */
public class PetsInstance {

    String name,breed,gender;
    long weight;

   // public PetsInstance(String name,String breed,String gender,long weight){
   public PetsInstance(String name,String breed){

        this.name=name;
        this.breed=breed;
      //  this.gender=gender;
      //  this.weight=weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public long getWeight() {
        return weight;
    }


}
