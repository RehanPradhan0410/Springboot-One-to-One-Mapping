package net.javatut.springboot.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")

public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Enumerated (EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfbirth;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
    private User user;

    public UserProfile()
    {

    }

    public UserProfile(String phoneNumber, String address, Gender gender, LocalDate dateOfbirth) {
        super();
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfbirth = dateOfbirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
