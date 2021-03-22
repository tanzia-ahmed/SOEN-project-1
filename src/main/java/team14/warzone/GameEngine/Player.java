package team14.warzone.GameEngine;

import team14.warzone.GameEngine.Commands.Command;
import team14.warzone.MapModule.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class implements the player model
 *
 * @author Anagh
 * @version 1.0
 */
public class Player {
    /**
     * name of player
     */
    private String d_Name;
    /**
     * number of armies in players possession
     */
    private int d_TotalNumberOfArmies;
    /**
     * track how many armies have been ordered to be deployed
     */
    private int d_ArmiesOrderedToBeDeployed;
    /**
     * list of countries owned by player
     */
    private ArrayList<Country> d_CountriesOwned;
    /**
     * list of orders issued by player that has not been executed
     */
    private ArrayList<Command> d_OrderList;
    /**
     * list of cards the player is holding
     */
    private ArrayList<Card> d_CardList;

    /**
     * Default constructor that takes no params
     */
    public Player() {
    }

    /**
     * Constructor that takes all attributes as params
     *
     * @param d_Name                name of the player
     * @param d_TotalNumberOfArmies total number of armies
     * @param d_CountriesOwned      list of countries (Country objects) owned by the player
     * @param d_OrderList           list of orders the player has issued but has not executed yet
     */
    public Player(String d_Name, int d_TotalNumberOfArmies, ArrayList<Country> d_CountriesOwned,
                  ArrayList<Command> d_OrderList) {
        this.d_Name = d_Name;
        this.d_TotalNumberOfArmies = d_TotalNumberOfArmies;
        this.d_CountriesOwned = d_CountriesOwned;
        this.d_OrderList = d_OrderList;
        d_ArmiesOrderedToBeDeployed = 0;
    }

    /**
     * Constructor that accepts playername and sets the other attributes with default values
     *
     * @param p_Name name of the player
     */
    public Player(String p_Name) {
        this(p_Name, 20, new ArrayList<Country>(Collections.emptyList()),
                new ArrayList<Command>(Collections.emptyList()));
    }

    /**
     * This method adds order to the list of orders
     *
     * @param p_Command command object to be stored
     */
    public void issueOrder(Command p_Command) {
        d_OrderList.add(p_Command);
    }

    public void issueOrderV2(List<List<String>> p_CommandStrList) {

    }

    /**
     * This method executes the first order in the order list
     * <ul>
     *     <li>Order list is maintained in a FIFO fasion</li>
     *     <li>Check if order list is empty</li>
     *     <li>Execute the order that was issued first</li>
     *     <li>After execution resize the list</li>
     * </ul>
     */
    public void nextOrder() {
        if (!d_OrderList.isEmpty()) {
            if (!d_OrderList.get(0).getD_Keyword().equals("pass"))
                d_OrderList.get(0).execute();//execute first order from the order list
            // remove the command after execution
            d_OrderList.remove(0);// remove first order from the order list
        }
    }

    /**
     * This method adds a country to the list of countries owned by the player
     *
     * @param p_Country country that is to be added
     */
    public void addCountryOwned(Country p_Country) {
        this.d_CountriesOwned.add(p_Country);
    }

    public boolean hasCard(Card p_Card) {
        return d_CardList.contains(p_Card);
    }

    /**
     * Getter method for name of the player
     *
     * @return name of the player
     */
    public String getD_Name() {
        return d_Name;
    }

    /**
     * Getter method for the total number of armies owned by the player
     *
     * @return total number of armies currently in players possession
     */
    public int getD_TotalNumberOfArmies() {
        return d_TotalNumberOfArmies;
    }

    /**
     * Getter method for the list of countries owned by the player
     *
     * @return list of countries owned
     */
    public ArrayList<Country> getD_CountriesOwned() {
        return d_CountriesOwned;
    }

    /**
     * Getter method for the list of orders issued by the player
     *
     * @return list of orders issued and not yet executed
     */
    public ArrayList<Command> getD_OrderList() {
        return d_OrderList;
    }

    /**
     * Setter method for the list of orders
     *
     * @param d_OrderList list or orders
     */
    public void setD_OrderList(ArrayList<Command> d_OrderList) {
        this.d_OrderList = d_OrderList;
    }

    /**
     * Setter method for the list of countries owned
     *
     * @param d_CountriesOwned list of countries owned
     */
    public void setD_CountriesOwned(ArrayList<Country> d_CountriesOwned) {
        this.d_CountriesOwned = d_CountriesOwned;
    }

    /**
     * Setter method for the number of armies
     *
     * @param d_TotalNumberOfArmies number of armies
     */
    public void setD_TotalNumberOfArmies(int d_TotalNumberOfArmies) {
        this.d_TotalNumberOfArmies = d_TotalNumberOfArmies;
    }

    /**
     * Setter method for the name of player
     *
     * @param d_Name name of player
     */
    public void setD_Name(String d_Name) {
        this.d_Name = d_Name;
    }

    /**
     * Getter for the number of armies ordered to be deployed field
     * @return
     */
    public int getD_ArmiesOrderedToBeDeployed() {
        return d_ArmiesOrderedToBeDeployed;
    }

    /**
     * Increase the number of armies ordered to be deployed field
     * @param p_ArmiesOrderedToBeDeploy
     */
    public void increaseArmiesOrderedToBeDeployed(int p_ArmiesOrderedToBeDeploy) {
        d_ArmiesOrderedToBeDeployed += p_ArmiesOrderedToBeDeploy;
    }

    /**
     * Decrease the number of armies ordered to be deployed field
     * @param p_ArmiesOrderedToBeDeploy
     */
    public void decreaseArmiesOrderedToBeDeployed(int p_ArmiesOrderedToBeDeploy) {
        d_ArmiesOrderedToBeDeployed -= p_ArmiesOrderedToBeDeploy;
    }
}
