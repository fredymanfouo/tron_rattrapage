package model;


public class Example {

	//Ici se trouvent des méthodes permettant de récupérer quelques données
	/**
	 * @author     fredy Manfouo 
	 * @since       2019-07-03
	 */
    private final int id;


    private String    name;
    

    public Example(final int id, final String name) 
    {
        super();
        this.id = id;
        this.name = name;

    }

    public int getId() 
    {
        return this.id;
    }

    public String getName() 
    {
        return this.name;
    }


    public void setName(final String name) 
    {
        this.name = name;
    }
    

    @Override
    public String toString() 
    {
        return this.getId() + " : " + this.getName();
    }
}
