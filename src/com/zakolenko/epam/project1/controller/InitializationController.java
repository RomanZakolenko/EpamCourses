package com.zakolenko.epam.project1.controller;

import com.zakolenko.epam.project1.controller.config.Config;
import com.zakolenko.epam.project1.model.entities.company.Operator;
import com.zakolenko.epam.project1.model.entities.tariff.Tariff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class InitializationController {

    public void initialize() {
        try (ObjectInputStream ous = new ObjectInputStream(new FileInputStream(Config.CONFIG.getMtsFile()))) {
            Operator.MTS.setTariffs((Set<Tariff>) ous.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ous = new ObjectInputStream(new FileInputStream(Config.CONFIG.getKyivstarFile()))) {
            Operator.KYIVSTAR.setTariffs((Set<Tariff>) ous.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
