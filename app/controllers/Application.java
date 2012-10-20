package controllers;

import models.Task;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

/**
 * Application controller
 */
public class Application extends Controller {

  /**
   * Task form
   */
  static Form<Task> taskForm = form(Task.class);

  /**
   * Index page. Redirects to task list
   * @return redirect response
   */
  public static Result index() {
    return redirect(routes.Application.tasks());
  }

  /**
   * Task list controller action. Will present the task list to the user
   * @return usually a 200 OK response with the task list template
   */
  public static Result tasks() {
    return ok(index.render(Task.all(), taskForm));
  }

  /**
   * Creates a new task in the underlying storage
   * @return BAD REQUEST on form error, OK otherwise
   */
  public static Result newTask() {
    Form<Task> filledForm = taskForm.bindFromRequest();
    if (filledForm.hasErrors()) {
      return badRequest(
          views.html.index.render(Task.all(), filledForm)
      );
    } else {
      Task.create(filledForm.get());
      return redirect(routes.Application.tasks());
    }
  }

  /**
   * Deletes task with given id
   * @param id id of the task to delete
   * @return A redirect to the task list
   */
  public static Result deleteTask(Long id) {
    Task.delete(id);
    return redirect(routes.Application.tasks());
  }
}
