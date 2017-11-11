import java.util.*;

public class Pokedex
{

    private Pokemon[] Arceus; //Arceus is the god after all

    public Pokedex(int p)
    {
        Arceus = new Pokemon[p];
    }

    /*
  * Return all the names of the Pokemon species in the
  * Pokedex
  */

    public String[] listPokemon()
    {
        int x = 0;
        int y = 0;
        String[] PokemonName;

        for (x= 0; x <= Arceus.length; x++)
        {
            if(x==Arceus.length)
            {
                y = x;
            }

            else if(Arceus[x]==null)
            {
                y = x;

                break;
            }
        }
        PokemonName = new String[y];
        for(int z = 0; z < y; z++)
        {
            PokemonName[z] = Arceus[z].getSpecies();
        }
        return PokemonName;
    }
    /*
    * Add a Pokemon to the Pokedex and return true if it can
    * actually be added to the Pokedex. If not, return false.
    * If the Pokemon trying to be added is already in the Pokedex,
    * then print out “Pokemon already in Pokedex” and return false.
    */

    public boolean addPokemon(String species)
    {
        if (Arceus[Arceus.length - 1]!=null)
        {
            System.out.println("Max");
            return false;
        }
        for (int z=0; z < Arceus.length; z++)
        {
            if (Arceus[z]==null)
            {
                Arceus[z] = new Pokemon(species);
                return true;
            }

            if (species.equalsIgnoreCase(Arceus[z].getSpecies()))
            {
                System.out.println("Duplicate");
                return false;
            }
        }


        return true;
    }

    /*
     * Return the stats of a certain Pokemon that you are
    * searching for.
    */

    public int[] checkStats(String species)
    {
        int[] stats = new int[3];
        boolean go = false;
        int d = 0;
        int a = 0;
        int b = 0;

        while (a==b)
        {
            if (Arceus[b]!=null) {
                if (species.equalsIgnoreCase ( Arceus[b].getSpecies () )) {
                    d = b;
                    b++;
                    go = true;
                } else {
                    a++;
                    b++;
                }
            }
            else
            {
                b++;
                go = true;
            }
        }
        if (!go)
        {
            stats[0]= 0;
            stats[1]= 0;
            stats[2]= 0;
        }

        else
        {
            stats[0]=Arceus[d].getAttack();
            stats[1]=Arceus[d].getDefense();
            stats[2]=Arceus[d].getSpeed();
        }
        return stats;
    }

    /*
    * Sort Pokedex in alphabetical order.
    */
    //copied some code from project 2
    public void sortPokedex()
    {

        for(int blue = 0; blue < Arceus.length; blue++)
        {
            for(int red = blue + 1; red < Arceus.length; red++)
            {
                try
                {
                    if(Arceus[blue].getSpecies().compareToIgnoreCase(Arceus[red].getSpecies()) > 0)
                    {
                        Pokemon temp = new Pokemon("temp");
                        temp = Arceus[blue];
                        Arceus[blue] = Arceus[red];
                        Arceus[red] = temp;
                    }
                }
                catch(NullPointerException e)
                {
                    break;
                }
            }
        }
    }

    /*
    * Evolve a certain Pokemon that you are searching for in the
    * Pokedex and return true if the Pokemon is actually in the
    * the Pokedex. If not, return false.
     */

    public boolean evolvePokemon(String species)
    {
        int x = -1;
        boolean plswork = false;

        for(int y = 0; y < Arceus.length; y++)
        {
            if((Arceus[y]!=null)&&(species.equalsIgnoreCase(Arceus[y].getSpecies())))
            {
                plswork = true;
                x = y;
            }
        }
        if(plswork)
        {
            Arceus[x].evolve ();
        }
        return plswork;
    }

}
