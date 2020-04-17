package org.lviv.lgs.homework;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String level;

    @Column(name = "primary_skill")
    private String primarySkill;

    public Participant() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int id;
        private String name;
        private String email;
        private String level;
        private String primarySkill;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setLevel(String level){
            this.level = level;
            return this;
        }

        public Builder setPrimarySkill(String primarySkill){
            this.primarySkill = primarySkill;
            return this;
        }

        public Participant build(){
            Participant participant = new Participant();
            participant.setId(id);
            participant.setName(name);
            participant.setEmail(email);
            participant.setLevel(level);
            participant.setPrimarySkill(primarySkill);

            return participant;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                ", primarySkill='" + primarySkill + '\'' +
                '}';
    }
}
