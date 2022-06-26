package com.blindeyestudios.supervisornotification.model;

import java.io.Serializable;

/**
 * The model class representing a NotificationRequest.
 * It contains methods for data relevant to each NotificationRequest
 */
public class NotificationRequest implements Serializable
{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String supervisor;

    /**
     * Default constructor.
     */
    public NotificationRequest() {}

    /**
     * Overloaded constructor for setting values of supplied fields
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param supervisor
     */
    public NotificationRequest(String firstName, String lastName, String email,
                               String phone, String supervisor)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.supervisor = supervisor;
    }

    /**
     * Retrieves the first name associated with the request
     *
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name associated with the request
     *
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name associated with the request
     *
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name associated with the request
     *
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Retrieves the email associated with the request
     *
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the email associated with the request
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Retrieves the phone number associated with the request
     *
     * @return
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the phone number associated with the request
     *
     * @param phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Retrieves the supervisor associated with the request
     *
     * @return
     */
    public String getSupervisor()
    {
        return supervisor;
    }

    /**
     * Sets the supervisor associated with the request
     *
     * @param supervisor
     */
    public void setSupervisor(String supervisor)
    {
        this.supervisor = supervisor;
    }

    /**
     * Convenience method for creating a human-readable String of the NotificationRequest's fields/info
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "NotificationRequest{" +
                ", first name: " + firstName +
                ", last name: " + lastName +
                ", email: " + email +
                ", phone: " + phone +
                ", supervisor: " + supervisor +
                "}";
    }
}
