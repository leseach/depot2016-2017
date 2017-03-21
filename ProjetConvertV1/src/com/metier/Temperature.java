package com.metier;

public class Temperature {
	/**
     * La valeur, exprim�e en degr�s Celsius
     */
    private double celsius;

    /**
     * Le constructeur, prend des Celsius en param�tres
    */
    public Temperature(double valeurCelsius)
    {
          celsius = valeurCelsius;
    }

    /**
     * Pour obtenir la valeur en Celsius
     *
     * @return Valeur de la temp�rature en Celsius
   */
    public double getCelsius() {
          return celsius;
    }

    /**
     * Pour obtenir la valeur en Fahrenheit
     *
     * @return Valeur de la temp�rature en Farenheit
    */
    public double getFahrenheit() {
          return (celsius * 9/5) + 32;
  }



}
