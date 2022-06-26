package com.blindeyestudios.supervisornotification.model;

import java.io.Serializable;

public class NotificationRequest implements Serializable
{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String supervisor;

    public NotificationRequest() {}

    public NotificationRequest(String firstName, String lastName, String email,
                               String phone, String supervisor)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.supervisor = supervisor;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getSupervisor()
    {
        return supervisor;
    }

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
