package com.velocity.practice.springbootdemo.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence",
                        sequenceName = "customer_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "customer_sequence")
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_mobile")
    private Long customerMobileNumber;

  /*  public Customer() {
    }

    public Customer(String customerName, String customerAddress, Long customerMobileNumber) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerMobileNumber = customerMobileNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(Long customerMobileNumber) {
        customerMobileNumber = customerMobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", CustomerMobileNumber=" + customerMobileNumber +
                '}';
    }

   */
}
