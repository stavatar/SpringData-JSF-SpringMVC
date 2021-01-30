package org.xtremebiker.jsfspring.model;

import javax.persistence.*;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "lastWork")
    private String lastWork;
    @Column(name = "countYears")
    private int countYears;
    @Column(name = "salary")
    private int salary;
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "position")
    private Position position;
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "interviewStage")
    private InterviewStage interview_stage;


    public void update(Candidate new_candidate)
    {
        id = new_candidate.getId();
        this.name =new_candidate.getName();
        this.lastWork =new_candidate.getLastWork();
        this.countYears = new_candidate.getCountYears();
        this.salary = new_candidate.getSalary();
        this.position = new_candidate.getPosition();
        this.interview_stage = new_candidate.getInterview_stage();
    }
}

