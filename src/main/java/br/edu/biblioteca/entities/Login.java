package br.edu.biblioteca.entities;

public class Login {
  private String accessToken;

  public Login(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return this.accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }  
}
