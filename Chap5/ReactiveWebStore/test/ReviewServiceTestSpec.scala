import org.scalatestplus.play._
import scala.collection.mutable
import services.IReviewService
import services.ReviewService

class ReviewServiceTestSpec extends PlaySpec {
    
      "ReviewService" must {
        
        val service:IReviewService = new ReviewService
      
        "insert a review properly" in {
           val review = new models.Review(Some(1),Some(1),"diegopacheco","Testing is Cool")
           service.insert(review)
        }
        
        "update a reviewt" in {
           val review = new models.Review(Some(1),Some(1),"diegopacheco","Testing so so Cool")
           service.update(1, review)
        }
        
        "not update because does not exit" in {
          intercept[RuntimeException]{
             service.update(333,null)
          }
        }
        
        "find the review 1" in {
           val review = service.findById(1)
           review.get.id mustBe Some(1)
           review.get.author mustBe "diegopacheco"
           review.get.comment mustBe "Testing so so Cool"
           review.get.productId mustBe Some(1)
        }
        
        "find all" in {
          val reviews = service.findAll()
          reviews.get.length mustBe 1
          reviews.get(0).id mustBe Some(1)
          reviews.get(0).author mustBe "diegopacheco"
          reviews.get(0).comment mustBe "Testing so so Cool"
          reviews.get(0).productId mustBe Some(1)
        }
        
        "remove 1 product" in {
          val product = service.remove(1)
          product mustBe true
          
          val oldProduct = service.findById(1)
          oldProduct mustBe None
        }
        
        "not remove because does not exit" in {
          intercept[RuntimeException]{
             service.remove(-1)
          }
        }
        
  }
 
  
}