package ordeManagement.src.Model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Enum userType;
    private Address address;
    private User(CreateUser createUser) {
        this.id = createUser.id;
        this.firstName = createUser.firstName;
        this.lastName = createUser.lastName;
        this.userType = createUser.userType;
        this.email = createUser.email;
        this.mobileNumber = createUser.mobileNumber;
        this.address = createUser.address;
    }
    public int getId() {
        return id;
    }
    public Address getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public Enum getUserType() {
        return userType;
    }
      
    public static class CreateUser {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private Enum userType;
        private Address address;
        
        public CreateUser setAddress(Address address) {
            this.address = address;
            return this;
        }
        public CreateUser setId(int id) {
            this.id = id;
            return this;
        }
        public CreateUser setEmail(String email) {
            this.email = email;
            return this;
        }
        public CreateUser setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public CreateUser setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public CreateUser setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }
        public CreateUser setUserType(Enum userType) {
            this.userType = userType;
            return this;
        }
        public User build() {
            return new User(this);
        } 
    }
    
}

