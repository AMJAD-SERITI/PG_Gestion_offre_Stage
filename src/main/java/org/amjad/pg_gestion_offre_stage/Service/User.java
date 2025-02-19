/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package org.amjad.pg_gestion_offre_stage.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface
User<T> {
    String addUser(T user);
    String deleteUser(Long id);
    String updateUser(Long id);
    T getUserById(Long id);
    List<T> getUsers();
    String validateUser(Long id);
    T getUserByEmail(String email);
    T saveUser(T user);
    String validatedUser(Long id);
    String unvalidateUser(Long id);
    List<T> getUser();
}
