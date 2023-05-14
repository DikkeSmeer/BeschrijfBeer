class Admin extends User {
    private boolean isAdmin;

    public Admin(String username, String password, String email,boolean isAdmin) {
        super(username, password, email);
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

