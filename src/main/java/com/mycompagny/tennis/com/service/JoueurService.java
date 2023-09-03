package com.mycompagny.tennis.com.service;

import com.mycompagny.tennis.com.repository.JoueurRepositorylmpl;

import com.mycompagny.tennis.com.repository.JoueurRepositoryImpl;
import entity.Joueur;

public class JoueurService {
    private JoueurRepositorylmpl joueurRepositorylmpl;
    public JoueurService() {
        this.joueurRepositorylmpl = new JoueurRepositorylmpl();
    }
    public void createJoueur(Joueur joueur) {
        joueurRepositorylmpl.create(joueur);
    }

    public Joueur getJoueur(Long id) {
       return joueurRepositorylmpl.delete(id);
    }


}

