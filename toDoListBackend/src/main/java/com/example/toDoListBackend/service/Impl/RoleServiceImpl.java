package com.example.toDoListBackend.service.Impl;

import com.example.toDoListBackend.model.Role;
import com.example.toDoListBackend.repository.RoleRepository;
import com.example.toDoListBackend.service.IRoleService;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService<Role> {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Collection<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}
	
	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role saveOrUpdate(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			roleRepository.deleteById(id);
			jsonObject.put("message", "Role deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}