package socigestionep;


class Socio implements CharSequence {
    private String nome;
    private String cognome;
    private int eta;
    private char sesso;

    public Socio(String nome, String cognome, int eta, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        if (eta<=0 || eta > 100){
            try {
                throw new ageNotValidException();
            } catch (ageNotValidException e) {
                
                e.printStackTrace();
            }
        }
        else{
            this.eta = eta;
        }
        if (sesso != 'M'||sesso != 'F' ){
            try {
                throw new sexNotValidException();
            } catch (sexNotValidException e) {
                
                e.printStackTrace();
            }
        }
        else{
            this.sesso = sesso;
        }
        
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public char getSesso() {
        return sesso;
    }
        public void setNome(String n) {
        this.nome=n;
    }

    public void setCognome(String c) {
       this.cognome=c;
    }

    public void setEta(int e) {
        this.eta=e;
    }

    public void setSesso(char s) {
        this.sesso=s;
    }

    public void incrementaEta() {
        eta++;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " - Età: " + eta + " - Sesso: " + sesso;
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'length'");
    }

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charAt'");
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subSequence'");
    }
}
