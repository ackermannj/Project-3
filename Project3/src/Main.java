import java.util.*;

public class Main
{

    /* Basically just prints out the menu selections and
    tries to stop any input mismatch exceptions. It should
    return the user's choice if it doesn't suck.
     */

    public static int MenuSelectionAndErrorCatch(Scanner scan)
    {
        //Menu that gets printed for the user to select from
        System.out.println("1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.println("\nWhat would you like to do?");

        boolean plsno = true;
        int menuchoice = 0;

    while (plsno) {
        try {
            menuchoice = scan.nextInt ();
            //If user choice is below 1 or above 6 throws error message
            if (menuchoice < 1 || menuchoice > 6) {
                System.out.println ( "\nThat is not a valid choice. Try again." );
            } else {
                plsno = false;  //Breaks loop
                return menuchoice;
            }
        }

            /*If user choice isn't a number, catches the mismatch exception and
            throws error message*/
            catch (InputMismatchException e) {
            System.out.println ( "\nThat is not a valid choice. Try again." );
        }
        //Catches everything else I hope
        catch (Exception e) {
            System.out.println ( "\nThat is not a valid choice. Try again." );
        } finally {
            scan.nextLine ();
        }
    }
        return menuchoice;
    }

    /*This is to recieve the size of the pokedex
    and avoid any random letters or symbols being
    entered and breaking my code
     */
    public static int pokedexSize()
    {
        Scanner scan = new Scanner (System.in);
        boolean plsno = true;
        int sizeOf = 0;
        System.out.println("Welcome to your new Pokedex!");
        System.out.println("How many pokemon are in your region: ");

        while (plsno)
        {
            try
            {
                sizeOf = scan.nextInt ();
                plsno = false;          //Gets and returns size of Pokedex if valid number
                return sizeOf;
            }

            catch (InputMismatchException e)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }

            //I'm not really sure what you'd type to trigger this but nice.
            catch (Exception e)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
            }

        }
        return sizeOf;  //Not sure why I returned it twice but it didnt work until I did
    }

    public static void main(String args[]) {

        int menuchoice = 0;
        Scanner scan = new Scanner (System.in);
        Pokemon pika;
        int pokemonmax;
        Pokedex ash;
        pokemonmax = pokedexSize();
        ash = new Pokedex(pokemonmax);
        System.out.println("Your new Pokedex can hold " + pokemonmax + " Pokemon. Let's start using it!");


        while(menuchoice != 6) {

            System.out.println ();
            menuchoice = MenuSelectionAndErrorCatch(scan);
                switch (menuchoice) {
                    case 1: // List all added Pokemon
                        String[] output = ash.listPokemon ();

                        for (int x = 0; x < output.length; x++) {
                            if (output[x] == null)
                                break;
                            System.out.println ( (x + 1) + ". " + output[x] );
                        }
                        break;

                    case 2: //Add a Pokemon
                        System.out.println ( "\nPlease enter the Pokemon's Species: " );
                        String pokemon = scan.nextLine ();
                        ash.addPokemon(pokemon);
                        break;

                    case 3: //Check stats
                        int[] PokemonStats = new int[3];
                        System.out.println ( "\nPlease enter the Pokemon of interest: " );
                        String pokemon1 = scan.nextLine ();
                        PokemonStats = ash.checkStats ( pokemon1 );
                        if ((PokemonStats[0] != 0) && (PokemonStats[1] != 0) && (PokemonStats[2] != 0)) {
                            System.out.println ( "\nThe stats for " + pokemon1 + " are: " );
                            System.out.println ( "Attack:  " + PokemonStats[0] );
                            System.out.println ( "Defense:  " + PokemonStats[1] );
                            System.out.println ( "Speed:  " + PokemonStats[2] );
                        } else {
                            System.out.println ( "Missing" );
                        }
                        break;


                    case 4: //Evolve
                        System.out.println ( "\nPlease enter the Pokemon of interest: " );
                        String pokemon2 = scan.nextLine ();

                        if (ash.evolvePokemon(pokemon2)) {
                            System.out.println (pokemon2 + " has evolved!");
                        } else {
                            System.out.println ( "Missing" );
                        }
                        break;

                    case 5: //Sort Pokedex
                        ash.sortPokedex ();
                        break;


                    default:
                        break;
                }
            }
    }
}
