package com.company;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

public class CodeTakhfif implements Serializable {

   private String Email;
   private String codeTakhfif;
   private String CodeMoaref;
   private int Darsad;
   private boolean Status;

    public CodeTakhfif(String email , int darsad , String codeTakhfif , String codeMoaref) {
        this.Email = email;
        this. Darsad = darsad;
        this.codeTakhfif = codeTakhfif;
        this.CodeMoaref = codeMoaref;
        Main.Takhfiflist.add(this);
        System.out.print(codeTakhfif);
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCodeTakhfif() {
        return codeTakhfif;
    }

    public void setCodeTakhfif(String code) {
        this.codeTakhfif = code;
    }

    public int getDarsad() {
        return Darsad;
    }

    public void setDarsad(int darsad) {
        Darsad = darsad;
    }

    public String getCodeMoaref() {
        return CodeMoaref;
    }

    public void setCodeMoaref(String codeMoaref) {
        CodeMoaref = codeMoaref;
    }

    @Override
    public String toString() {
        return "CodeTakhfif { "  + codeTakhfif +
                " } ";
    }
}
