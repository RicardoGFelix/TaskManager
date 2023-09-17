import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerJUnit5Tests {

    public static final String SUCCESS_TO_CREATE_TASK = "Tarefa criada com sucesso!";
    public static final String SUCCESS_TO_CHANGE_TITLE = "Título alterado com sucesso!";
    public static final String SUCCESS_TO_CHANGE_DESCRIPTION = "Descrição alterada com sucesso!";
    public static final String SUCCESS_TO_CHANGE_LIMIT_DATE = "Data de Vencimento alterada com sucesso!";
    public static final String SUCCESS_TO_CHANGE_PRIORITY = "Prioridade alterada com sucesso!";
    public static final String SUCCESS_TO_REMOVE_TASK = "Tarefa removida com sucesso!";
    public static final String SUCCESS_TO_LIST_TASKS = "1 - Cozinhar - Preciso cozinhar o almoço - 12/09/2023 - Alta\n" +
            "2 - Preparar projeto de TCC - Preciso preparar o projeto do meu TCC, contendo resumo, introdução, objetivos, metodologia, cronograma e bibliografia - 01/11/2023 - Média\n" +
            "0 - Comprar papete do Senninha - Preciso comprar a papete do Senninha para passar o réveillon com ela - 30/12/2023 - Baixa\n"

    @DisplayName("Testing success in creating a task")
    @Test
    public void testSuccessToCreateTask() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Comprar papete do Senninha";
        String descriptionTask = "Preciso comprar a papete do Senninha para passar o réveillon com ela";
        String limitDateTask = "30/12/2023";
        String priorityTask = "Baixa";

        assertEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing success in creating a task with a current deadline")
    @Test
    public void testSuccessToCreateTaskWithActualDate() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Cozinhar";
        String descriptionTask = "Preciso cozinhar o almoço";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String limitDateTask = dtf.format(localDate);
        String priorityTask = "Alta";

        assertEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing success in creating a task with medium priority")
    @Test
    public void testSuccessToCreateTaskWithMediumPriority() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Preparar projeto de TCC";
        String descriptionTask = "Preciso preparar o projeto do meu TCC, contendo resumo, introdução, objetivos, metodologia, cronograma e bibliografia";
        String limitDateTask = "01/11/2023";
        String priorityTask = "Média";

        assertEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with empty title")
    @Test
    public void testErrorToCreateTaskWithEmptyTitle() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "";
        String descriptionTask = "Preciso codificar game da disciplina de Jogos Digitais";
        String limitDateTask = "06/11/2023";
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with null title")
    @Test
    public void testErrorToCreateTaskWithNullTitle() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = null;
        String descriptionTask = "Preciso codificar game da disciplina de Jogos Digitais";
        String limitDateTask = "06/11/2023";
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with null description")
    @Test
    public void testErrorToCreateTaskWithNullDescription() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Criar game de Jogos Digitais";
        String descriptionTask = null;
        String limitDateTask = "06/11/2023";
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with empty deadline")
    @Test
    public void testErrorToCreateTaskWithEmptyLimitDate() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Criar game de Jogos Digitais";
        String descriptionTask = "Preciso codificar game da disciplina de Jogos Digitais";
        String limitDateTask = "";
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with null deadline")
    @Test
    public void testErrorToCreateTaskWithNullLimitDate() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Criar game de Jogos Digitais";
        String descriptionTask = "Preciso codificar game da disciplina de Jogos Digitais";
        String limitDateTask = null;
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with past deadline")
    @Test
    public void testErrorToCreateTaskWithPastLimitDate() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Ir ao show de Fagner";
        String descriptionTask = "Preciso ir ao show de Fagner no Parque do Povo";
        String limitDateTask = "24/06/2023";
        String priorityTask = "Média";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with empty priority")
    @Test
    public void testErrorToCreateTaskWithEmptyPriority() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Visitar o Museu Digital de Campina Grande";
        String descriptionTask = "Preciso visitar o Museu Digital de Campina Grande, que é bastante inovador e tecnológico";
        String limitDateTask = "31/12/2023";
        String priorityTask = "";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with null priority")
    @Test
    public void testErrorToCreateTaskWithNullPriority() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Visitar o Museu Digital de Campina Grande";
        String descriptionTask = "Preciso visitar o Museu Digital de Campina Grande, que é bastante inovador e tecnológico";
        String limitDateTask = "31/12/2023";
        String priorityTask = null;

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing error in creating a task with invalid priority")
    @Test
    public void testErrorToCreateTaskWithInvalidPriority() {
        TaskManagerController taskManagerController = new TaskManagerController();

        String titleTask = "Visitar o Museu Digital de Campina Grande";
        String descriptionTask = "Preciso visitar o Museu Digital de Campina Grande, que é bastante inovador e tecnológico";
        String limitDateTask = "31/12/2023";
        String priorityTask = "Altíssima";

        assertNotEquals(SUCCESS_TO_CREATE_TASK, taskManagerController.createTask(titleTask, descriptionTask, limitDateTask, priorityTask));
    }

    @DisplayName("Testing success in changing the title of a task")
    @Test
    public void testSuccessToChangeTitle() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(1, "Cozinhar as refeições da semana"));
    }

    @DisplayName("Testing success in changing the title of a task with a minimum index")
    @Test
    public void testSuccessToChangeTitleWithMinimumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(0, "Comprar papete e camiseta do Senninha"));
    }

    @DisplayName("Testing success in changing the title of a task with a maximum index")
    @Test
    public void testSuccessToChangeTitleWithMaximumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(2, "Preparar documento do projeto de TCC"));
    }

    @DisplayName("Testing error in changing the title of a task because the index is negative")
    @Test
    public void testErrorToChangeTitleWithNegativeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(-1, "Comprar roupas para a viagem"));
    }

    @DisplayName("Testing error in changing a task title because the index is greater than or equal to the list size")
    @Test
    public void testErrorToChangeTitleWithListSizeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(3, "Comprar roupas para a viagem"));
    }

    @DisplayName("Testing error in changing the title of a task because the new title is empty")
    @Test
    public void testErrorToChangeTitleWithEmptyTitle() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(1, ""));
    }

    @DisplayName("Testing error in changing the title of a task because the new title is null")
    @Test
    public void testErrorToChangeTitleWithNullTitle() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_TITLE, taskManagerController.updateTitleTask(1, null));
    }

    @DisplayName("Testing success in changing the description of a task")
    @Test
    public void testSuccessToChangeDescription() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(1, "Preciso cozinhar as refeições da semana, ou não terei o que almoçar nos próximos dias"));
    }

    @DisplayName("Testing success in changing the description of a task with minimum index")
    @Test
    public void testSuccessToChangeDescriptionWithMinimumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(0, "Preciso comprar a papete e a camiseta do Senninha para passar o réveillon padronizado"));
    }

    @DisplayName("Testing success in changing the description of a task with maximum index")
    @Test
    public void testSuccessToChangeDescriptionWithMaximumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(2, "Preciso preparar o documento do projeto do meu TCC, contendo resumo, introdução, objetivos, metodologia, cronograma e bibliografia"));
    }

    @DisplayName("Testing error in changing the description of a task because the index is negative")
    @Test
    public void testErrorToChangeDescriptionWithNegativeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(-1, "Preciso cozinhar as refeições da semana, ou não terei o que almoçar nos próximos dias"));
    }

    @DisplayName("Testing error in changing a task description because the index is greater than or equal to the list size")
    @Test
    public void testErrorToChangeDescriptionWithListSizeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(3, "Preciso cozinhar as refeições da semana, ou não terei o que almoçar nos próximos dias"));
    }

    @DisplayName("Testing error in changing the description of a task because the new description is null")
    @Test
    public void testErrorToChangeDescriptionWithNullDescription() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_DESCRIPTION, taskManagerController.updateDescriptionTask(1, null));
    }

    @DisplayName("Testing success in changing the deadline of a task")
    @Test
    public void testSuccessToChangeLimitDate() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(1, "15/09/2023"));
    }

    @DisplayName("Testing success in changing the deadline of a task with a minimum index")
    @Test
    public void testSuccessToChangeLimitDateWithMinimumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(0, "28/10/2023"));
    }

    @DisplayName("Testing success in changing the deadline of a task with a maximum index")
    @Test
    public void testSuccessToChangeLimitDateWithMaximumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(2, "30/10/2023"));
    }

    @DisplayName("Testing error in changing the deadline of a task because the index is negative")
    @Test
    public void testErrorToChangeLimitDateWithNegativeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(-1, "15/08/2024"));
    }

    @DisplayName("Testing error in changing the deadline of a task because the index is greater than or equal to the list size")
    @Test
    public void testErrorToChangeLimitDateWithListSizeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(3, "30/11/2023"));
    }

    @DisplayName("Testing error in changing the deadline of a task because the new date is empty")
    @Test
    public void testErrorToChangeLimitDateWithEmptyDate() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(1, ""));
    }

    @DisplayName("Testing error in changing the deadline of a task because the new date is null")
    @Test
    public void testErrorToChangeLimitDateWithNullDate() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(1, null));
    }

    @DisplayName("Testing error in changing the deadline of a task because the new date is past")
    @Test
    public void testErrorToChangeLimitDateWithPastDate() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_LIMIT_DATE, taskManagerController.updateDateTask(1, "15/08/2023"));
    }

    @DisplayName("Testing success in changing the priority of a task")
    @Test
    public void testSuccessToChangePriority() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updatePriorityTask(1, "Alta"));
    }

    @DisplayName("Testing success in changing the priority of a task with a minimum index")
    @Test
    public void testSuccessToChangePriorityWithMinimumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updatePriorityTask(0, "Média"));
    }

    @DisplayName("Testing success in changing the priority of a task with a maximum index")
    @Test
    public void testSuccessToChangePriorityWithMaximumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updatePriorityTask(2, "Alta"));
    }

    @DisplayName("Testing error in changing the priority of a task because the index is negative")
    @Test
    public void testErrorToChangePriorityWithNegativeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updatePriorityTask(-1, "Baixa"));
    }

    @DisplayName("Testing error in changing the priority of a task because the index is greater than or equal to the list size")
    @Test
    public void testErrorToChangePriorityWithListSizeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updatePriorityTask(3, "Baixa"));
    }

    @DisplayName("Testing error in changing the priority of a task because the new priority is empty")
    @Test
    public void testErrorToChangePriorityWithEmptyPriority() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updateTitleTask(1, ""));
    }

    @DisplayName("Testing error in changing the priority of a task because the new priority is null")
    @Test
    public void testErrorToChangePriorityWithNullPriority() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updateTitleTask(1, null));
    }

    @DisplayName("Testing error in changing the priority of a task because the new priority is invalid")
    @Test
    public void testErrorToChangePriorityWithInvalidPriority() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_CHANGE_PRIORITY, taskManagerController.updateTitleTask(2, "Altíssima"));
    }

    @DisplayName("Testing success in removing a task")
    @Test
    public void testSuccessToRemoveTask() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_REMOVE_TASK, taskManagerController.removeTask(1));
    }

    @DisplayName("Testing success in removing a task with a minimum index")
    @Test
    public void testSuccessToRemoveTaskWithMinimumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_REMOVE_TASK, taskManagerController.removeTask(0));
    }

    @DisplayName("Testing success in removing a task with a maximum index")
    @Test
    public void testSuccessToRemoveTaskWithMaximumIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_REMOVE_TASK, taskManagerController.removeTask(2));
    }

    @DisplayName("Testing error in removing a task because the index is negative")
    @Test
    public void testErrorToRemoveTaskWithNegativeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_REMOVE_TASK, taskManagerController.removeTask(-1));
    }

    @DisplayName("Testing error in removing a task because the index is greater than or equal to the list size")
    @Test
    public void testErrorToRemoveTaskWithListSizeIndex() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertNotEquals(SUCCESS_TO_REMOVE_TASK, taskManagerController.removeTask(3));
    }

    @DisplayName("Testing success to list tasks")
    @Test
    public void testSuccessToListTasks() {
        TaskManagerController taskManagerController = getPopulatedTaskManager();
        assertEquals(SUCCESS_TO_LIST_TASKS, taskManagerController.getSortedTasks());
    }

    @DisplayName("Testing success to list tasks with empty list")
    @Test
    public void testSuccessToListTasks() {
        TaskManagerController taskManagerController = new TaskManagerController();

        assertEquals("", taskManagerController.getSortedTasks());
    }

    private TaskManagerController getPopulatedTaskManager() {
        TaskManagerController taskManagerController = new TaskManagerController();

        taskManagerController.createTask("Comprar papete do Senninha", "Preciso comprar a papete do Senninha para passar o réveillon com ela", "30/12/2023", "Baixa");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        taskManagerController.createTask("Cozinhar", "Preciso cozinhar o almoço", dtf.format(localDate), "Alta");
        taskManagerController.createTask("Preparar projeto do TCC", "Preciso preparar o projeto do meu TCC, contendo resumo, introdução, objetivos, metodologia, cronograma e bibliografia", "01/11/2023", "Média");

        return taskManagerController;
    }
}
