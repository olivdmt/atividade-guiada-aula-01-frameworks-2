package com.example.task_api;

import com.example.task_api.controller.TaskController;
import com.example.task_api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class TaskApiApplicationTests {

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		TaskRepository taskRepository = new TaskRepository();
		TaskController taskController = new TaskController(taskRepository);
		mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testCrudOperations() throws Exception {
		String taskJson = """
				{
				  "id": 1,
				  "title": "Casa",
				  "description": "Organizar as tarefas de casa",
				  "dueDate": "2026-12-31T00:00:00"
				}
				""";

		mockMvc.perform(post("/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content(taskJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.title").value("Casa"));

		mockMvc.perform(get("/tasks"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].title").value("Casa"));

		mockMvc.perform(get("/tasks/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Casa"));

		String updateJson = """
				{
				  "id": 1,
				  "title": "trabalho",
				  "description": "Organizar as tarefas do trabalho",
				  "dueDate": "2026-12-25T10:00:00"
				}
				""";

		mockMvc.perform(put("/tasks/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(updateJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("trabalho"));

		mockMvc.perform(delete("/tasks/1"))
				.andExpect(status().isOk());

		mockMvc.perform(get("/tasks/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").doesNotExist());
	}
}

