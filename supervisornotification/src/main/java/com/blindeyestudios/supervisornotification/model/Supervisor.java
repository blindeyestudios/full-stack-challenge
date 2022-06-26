package com.blindeyestudios.supervisornotification.model;

import java.io.Serializable;

/**
 * The model class representing a Supervisor.
 * It simply contains fields corresponding to data relevant to each supervisor
 */
public class Supervisor implements Serializable, Comparable {

    /* Fields for supervisor data */
    private int id;

    private String phone;

    private String jurisdiction;

    private String identificationNumber;

    private String firstName;

    private String lastName;

    /**
     * Default constructor.
     */
    public Supervisor() {};

    /**
     * Overloaded constructor supplying data for all Supervisor fields
     *
     * @param id
     * @param phone
     * @param jurisdiction
     * @param identificationNumber
     * @param firstName
     * @param lastName
     */
    public Supervisor(int id, String phone, String jurisdiction, String identificationNumber, String firstName, String lastName)
    {
        this.id = id;
        this.phone = phone;
        this.jurisdiction = jurisdiction;
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the Supervisor's ID
     *
     * @return
     */
    public int getID()
    {
        return id;
    }

    /**
     * Sets the Supervisor's ID
     *
     * @return
     */
    public void setID(int id)
    {
        this.id = id;
    }

    /**
     * Retrieves the Supervisor's phone number
     *
     * @return
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the Supervisor's ID
     *
     * @return
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Retrieves the Supervisor's jurisdiction
     *
     * @return
     */
    public String getJurisdiction()
    {
        return jurisdiction;
    }

    /**
     * Sets the Supervisor's jurisdiction
     *
     * @return
     */
    public void setJurisdiction(String jurisdiction)
    {
        this.jurisdiction = jurisdiction;
    }

    /**
     * Retrieves the Supervisor's identification number
     *
     * @return
     */
    public String getIdentificationNumber()
    {
        return identificationNumber;
    }

    /**
     * Sets the Supervisor's identification number
     *
     * @return
     */
    public void setIdentificationNumber(String identificationNumber)
    {
        this.identificationNumber = identificationNumber;
    }

    /**
     * Retrieves the Supervisor's first name
     *
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the Supervisor's first name
     *
     * @return
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Retrieves the Supervisor's last name
     *
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the Supervisor's last name
     *
     * @return
     */
    public void setLastname(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Convenience method for creating a human-readable String of the Supervisor's fields/info
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Supervisor{" +
                ", id: " + id +
                ", phone: " + phone +
                ", identification number: " + identificationNumber +
                ", first name: " + firstName +
                ", last name: " + lastName +
                "}";
    }

    /**
     * Specialized comparison that compares in the following order:
     *
     * 1. Jurisdiction
     * 2. Last Name
     * 3. First Name
     *
     * It should be noted that compareTo() for Strings is already based on alphabetical order, which is nice
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o)
    {
        // Make sure we're comparing to another Supervisor
        if (o instanceof Supervisor)
        {
            Supervisor otherSup = (Supervisor) o;

            // First comparison is based on jurisdiction
            String otherJurisdiction = otherSup.getJurisdiction();
            if (jurisdiction.equals(otherJurisdiction))
            {
                // Second comparison is based on last name
                String otherLastName = otherSup.getLastName();
                if (lastName.equals(otherLastName))
                {
                    // Third comparison is based on first name
                    String otherFirstName = otherSup.getFirstName();
                    if (firstName.equals(otherFirstName))
                    {
                        // Doesn't really matter if we return 1 or -1 at this point, as all fields are equal
                        return 1;
                    }
                    return firstName.compareTo(otherFirstName) > 0 ? 1 : -1;
                }
                return lastName.compareTo(otherLastName) > 0 ? 1 : -1;
            }
            return jurisdiction.compareTo(otherJurisdiction) > 0 ? 1 : -1;
        }
        // As we have no instruction for how to handle comparisons with other object types,
        // we'll assume that if it happens, a Supervisor will be sorted "higher"
        return 1;
    }
}
