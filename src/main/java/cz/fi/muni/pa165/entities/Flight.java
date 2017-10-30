package cz.fi.muni.pa165.entities;


import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * The entity representing a flight.
 *
 * @author Karel Jiranek
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Destination departureLocation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Destination arrivalLocation;

    @Nullable
    private LocalDateTime arrivalTime;

    @Nullable
    private LocalDateTime departureTime;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Nullable
    private List<Steward> stewards;

    @Nullable
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Airplane airPlane;

    public Flight() {
    }

    public Flight(Destination departureLocation,
                  Destination arrivalLocation,
                  LocalDateTime arrivalTime,
                  LocalDateTime departureTime,
                  List<Steward> stewards, Airplane airPlane) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stewards = stewards;
        this.airPlane = airPlane;
    }

    /**
     * Return entity id
     *
     * @return Id of entity
     */
    public Long getId() {
        return id;
    }

    /**
     * Set entity's id
     *
     * @param id Id to set to the entity
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Destination getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Destination departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Destination getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(Destination arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departueTime) {
        this.departureTime = departueTime;
    }

    public List<Steward> getStewards() {
        return stewards;
    }

    public void setStewards(List<Steward> stawards) {
        this.stewards = stawards;
    }

    public Airplane getAirPlane() {
        return airPlane;
    }

    public void setAirPlane(Airplane airPlane) {
        this.airPlane = airPlane;
    }


    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Flight:\n")
                .append("Departure location: ").append(departureLocation).append("\n")
                .append("Departure time: ").append(departureTime).append("\n")
                .append("Arrival location: ").append(arrivalLocation).append("\n")
                .append("Arrival time: ").append(arrivalTime).append("\n")
                .append("Airplane: ").append(airPlane);
        //.append("Stewards: ").append(stawards);
        return strBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight that = (Flight) o;

        if (departureTime == null) {
            if (that.getDepartureTime() != null) {
                return false;
            }
        } else {
            if (!departureTime.equals(that.getDepartureTime()))
                return false;
        }

        if (arrivalTime == null) {
            if (that.getArrivalTime() != null) {
                return false;
            }
        } else {
            if (!arrivalTime.equals(that.getArrivalTime()))
                return false;
        }

        if (stewards == null) {
            if (that.getStewards() != null) {
                return false;
            }
        } else {
            if (!stewards.equals(that.getStewards()))
                return false;
        }

        if (airPlane == null) {
            if (that.getAirPlane() != null) {
                return false;
            }
        } else {
            if (!airPlane.equals(that.getAirPlane()))
                return false;
        }


        if (!departureLocation.equals(that.getDepartureLocation()) ||
                !arrivalLocation.equals(that.getArrivalLocation())
                ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result += prime * result + Objects.hashCode(this.id);
        result += prime * result + Objects.hashCode(departureTime);
        result += prime * result + Objects.hashCode(departureLocation);
        result += prime * result + Objects.hashCode(arrivalTime);
        result += prime * result + Objects.hashCode(arrivalLocation);
        result += prime * result + Objects.hashCode(airPlane);
        result += prime * result + Objects.hashCode(stewards);
        return result;
    }
}