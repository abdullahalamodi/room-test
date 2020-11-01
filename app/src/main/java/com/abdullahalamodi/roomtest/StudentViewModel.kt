
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.abdullahalamodi.roomtest.Student
import com.abdullahalamodi.roomtest.StudentRepository
import java.util.*

class StudentViewModel : ViewModel() {

    private val studentRepository = StudentRepository.get();
    private val studentIdLiveData = MutableLiveData<UUID>();


    val studentsLiveData = studentRepository.getStudents();
    //prepare liveDate to git crime if id change
    val studentLiveData: LiveData<Student?> =
        Transformations.switchMap(studentIdLiveData){ studentId ->
            studentRepository.getStudent(studentId)
        }

    fun loadStudent(studentId: UUID) {
        studentIdLiveData.value = studentId
    }

    fun saveStudent(student: Student) {
        studentRepository.updateStudent(student)
    }

    fun addStudent(student: Student) {
        studentRepository.addStudent(student)
    }

}