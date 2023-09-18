import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TaskManagerController {

    private List<Task> tasks;

    public TaskManagerController() {
        this.tasks = new ArrayList<Task>();
    }

    public String createTask(String title, String description, String date, String priority) throws Exception {
        try {
            String result;

            if (title == null || title == "") {
                result = "O título informado é inválido!";
            } else if (description == null) {
                result = "A descrição informada é inválida!";
            } else if (date == null || date == "") {
                result = "A data de vencimento informada é inválida!";
            } else if (priority == null || priority == "") {
                result = "A prioridade informada é inválida!";
            } else {
                LocalDate dateTask = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (dateTask.isBefore(LocalDate.now())) {
                    result = "A data de vencimento informada já passou!";
                } else if (priority != "Baixa" && priority != "Média" && priority != "Alta") {
                    result = "A prioridade informada é inválida!";
                } else {
                    Task task = new Task(title, description, dateTask, priority);

                    if (!this.tasks.contains(task)) {
                        this.tasks.add(task);
                        result = "Tarefa criada com sucesso!";
                    } else {
                        result = "Erro ao criar tarefa!";
                    }
                }

            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public String updateTitleTask(int i, String title) throws Exception {
        try {
            String result;

            if (title == null || title == "") {
                result = "Erro ao atualizar título de tarefa!";
            } else if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setTitle(title);

                result = "Título alterado com sucesso!";
            } else {
                result = "Índice inválido!";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDescriptionTask(int i, String description) throws Exception {
        try {
            String result;

            if (description == null) {
                result = "Erro ao atualizar descrição de tarefa!";
            } else if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setDescription(description);

                result = "Descrição alterada com sucesso!";
            } else {
                result = "Índice inválido!";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDateTask(int i, String date) throws Exception {
        try {
            String result;


            if (date == null || date == "") {
                result = "Erro ao atualizar data de vencimento de tarefa!";
            } else if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateTask = LocalDate.parse(date, formatter);

                LocalDate today = LocalDate.now();

                if (dateTask.isBefore(today)) {
                    result = "A data de vencimento informada já passou!";
                } else {
                    task.setDate(dateTask);
                    result = "Data de Vencimento alterada com sucesso!";
                }
            } else {
                result = "Índice inválido!";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updatePriorityTask(int i, String priority) throws Exception {
        try {
            String result;

            if ((priority != "Baixa" && priority != "Média" && priority != "Alta") || priority == null || priority == "") {
                result = "A prioridade informada é inválida!";
            } else if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setPriority(priority);

                result = "Prioridade alterada com sucesso!";
            } else {
                result = "Índice inválido";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String removeTask(int i) throws Exception {
        try {
            String result;

            if (i >= 0 && i < this.tasks.size()) {
                this.tasks.remove(i);
                result = "Tarefa removida com sucesso!";
            } else {
                result = "Índice inválido";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public String getSortedTasks() throws Exception {
        try {
            String result = "";

            TaskComparator comparator = new TaskComparator();
            Collections.sort(this.tasks, comparator);

            for (int i = 0; i < this.tasks.size(); i++) {
                result += i+1 + " - " + this.tasks.get(i).toString() + "\n";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
