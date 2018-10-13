//package list.todo.com.todolist;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class ToDoListAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//    private List<ToDoList> toDoLists;
//
//    public ToDoListAdapter(List<ToDoList> toDoLists) {
//        this.toDoLists = toDoLists;
//    }
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View todoListView = inflater.inflate(R.layout.view_list, parent,false);
//
//        return new ViewHolder(todoListView);
//    }
//
////
////
////    @Override
////    public void onBindViewHolder(ViewHolder holder, int position) {
////        ToDoList toDoList = toDoLists.get(position);
////        holder.titleTextView.setText("Title : "+toDoList.getTitle());
////        holder.taskTextView.setText("Task : "+toDoList.getTask());
////
////    }
//
//    @Override
//    public int getItemCount() {
//        return toDoLists.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        public TextView titleTextView;
//        public TextView taskTextView;
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            titleTextView = itemView.findViewById(R.id.titleTextView);
//            taskTextView = itemView.findViewById(R.id.taskTextView);
//
//        }
//    }
//}
